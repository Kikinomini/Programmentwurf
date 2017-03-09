// TODO: Refactor!!!!!!11!!!1!

package de.dhbw.it2016.pe.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.MainMenuSelector;
import de.dhbw.it2016.pe.Exceptions.*;
import de.dhbw.it2016.pe.Models.*;
import de.dhbw.it2016.pe.View.StudentenVerwaltungView;

/* Manages the entire behavior of the program,
 * i.e. the administration of the menus.
 */
public class StudentController {

	/***************************************************************************************
	 * 
	 * Class variables
	 * 
	****************************************************************************************/

	// Serves as interface to the main output device.
	private StudentenVerwaltungView view = new StudentenVerwaltungView();

	// Stores the last input from the console.
	private String consoleInput;

	// The enumeration "userSelection" displays a user's choice.
	MainMenuSelector userSelection = null;

	// Gets or sets whether a student is selected or not.
	private boolean studentSelected = false;
	
	// Gets or sets whether the user closes the program or not.
	private boolean programClosing = false;
	
	/*
	 * This method serves as a connection to the datastore.csv file.
	 */
	public List<String> readDataFromStore(String id)
	{
		// The data list stores all the information out of one line.
		List<String> data = DataStore.read(id);
		return data;
	}
			
	/***************************************************************************************
	 * 
	 * Menu Functions
	 * 
	****************************************************************************************/
	
	public void manageMainMenu(BufferedReader cin) throws IOException, NullPointerException
	{
		programClosing = false;
		do {
			
			// Loading the initial screen
			view.welcomeView();
			view.showMainMenu();		

			StudentFactory studFactory = new StudentFactory();
			consoleInput = cin.readLine();

			String id = null;
			Student student = null;
			
			try {
				int tempUserSelection = Integer.parseInt(consoleInput);
				userSelection = MainMenuSelector.values()[tempUserSelection];
			} 
			catch (NumberFormatException e) 
			{
				view.invalidFormat();
				continue;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				view.invalidInputNumber();
				continue;
			}
			
			// From here on, the user input will be processed (if it was valid).
			
			switch (userSelection) 
			{
			
			case SearchStudentByID:
				do
				{
					view.enterId();
					id = cin.readLine();
					List<String> data = readDataFromStore(id);
			
					if(data.isEmpty())
					{
					    view.invalidStudentId();
						continue;
					}
					
					try 
					{
					    student = studFactory.createStudent(data);
					    view.studentSuccessfullySelected(student.getIdentInfo());
					    studentSelected = true;
					}
					catch (InvalidCountryCodeException e) 
					{
						view.invalidCountryNumber();
						continue;
					}
					catch (IndexOutOfBoundsException e) 
					{
					    	view.corruptedDatabase();
					    	continue;
					}
					catch (Exception e) 
					{
					    view.unknownError();
					}
					
				} while(studentSelected == false);
				
				try {
				    programClosing = this.subMenu(cin, student);
				} catch (InvalidInputIDException e) {
					view.invalidInputNumber();
				}	
				break;
				
			case ExitProgram:
				view.closeView();
				programClosing = true;
				break;
				
			default:
				view.invalidInputNumber();
				continue;
			}
		} while (programClosing == false);	
	}

	private boolean subMenu(BufferedReader cin, Student student) throws InvalidInputIDException, IOException 
	{
		do{
			view.menuView();
			consoleInput = cin.readLine();

			try {
				int tempUserSelection = Integer.parseInt(consoleInput);
				userSelection = MainMenuSelector.values()[tempUserSelection];
			} catch (NumberFormatException e) {
				view.invalidFormat();
				continue;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				view.invalidFormat();
				continue;
			}
			
			switch (userSelection) 
			{
				case DisplayInfo:
					view.printParameter(student.getIdentInfo());
					continue;
					
				case DisplayAddress:
					view.printParameter(student.address());	
					continue;
					
				case DisplayPhoneNumber:
					view.printParameter(student.phone());
					continue;
					
				case DisplayIntlPhoneNumber:
					view.printParameter(student.intlPhone());
					continue;
					
				case Back:
					studentSelected = false;
					break;

				case ExitProgram:
					view.closeView();
					programClosing = true;
					break;	
					
				default:
					view.invalidFormat();
					break;
			}
		} while (studentSelected == true && programClosing == false);
		
		return programClosing;
	}	
}
