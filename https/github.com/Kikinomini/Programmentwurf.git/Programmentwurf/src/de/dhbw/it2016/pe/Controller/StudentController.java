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

		Student student = null;
		String id = null;

		do {
			
			// Loading the initial screen
			view.showWelcomeView();
			view.showMainMenu();		

			consoleInput = cin.readLine();

			// Select a user by input of an ID from the console
			userSelection = selectUserFromInputStream();
			if (userSelection == null) {
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
					    view.errorInvalidStudentId();
						continue;
					}
					
					/* 
					 * Selects a student out of the ID. If successful,
					 * the studentSelected ID is set to true and the do while loop can
					 * be left. If not successful, the student is null.
					 */
					student = selectStudentFromID(data);
					
					// If student was not loaded successfully (i.e. is not selected),
					// the do while loop continues.
				} while(studentSelected == false);
				
				try {
				    programClosing = this.subMenu(cin, student);
				} catch (InvalidInputIDException e) {
					view.errorInvalidInputNumber();
				}	
				break;
				
			case ExitProgram:
				view.showCloseView();
				programClosing = true;
				break;
				
			default:
				view.errorInvalidInputNumber();
				continue;
			}
		} while (programClosing == false);	
	}

	private boolean subMenu(BufferedReader cin, Student student) throws InvalidInputIDException, IOException 
	{
		do{
			view.showSubMenu();
			consoleInput = cin.readLine();

			// Select a user by input of an ID from the console
			userSelection = selectUserFromInputStream();
			if (userSelection == null) {
				continue;
			}
			
			switch (userSelection) 
			{
				case DisplayInfo:
					view.printArbitraryInputString(student.getIdentInfo());
					continue;
					
				case DisplayAddress:
					view.printArbitraryInputString(student.address());	
					continue;
					
				case DisplayPhoneNumber:
					view.printArbitraryInputString(student.phone());
					continue;
					
				case DisplayIntlPhoneNumber:
					view.printArbitraryInputString(student.intlPhone());
					continue;
					
				case Back:
					studentSelected = false;
					break;

				case ExitProgram:
					view.showCloseView();
					programClosing = true;
					break;	
					
				default:
					view.errorInvalidFormat();
					break;
			}
		} while (studentSelected == true && programClosing == false);
		
		return programClosing;
	}
	
	private MainMenuSelector selectUserFromInputStream() {
		try {
			int tempUserSelection = Integer.parseInt(consoleInput);
			return MainMenuSelector.values()[tempUserSelection];
		} 
		catch (NumberFormatException e) 
		{
			view.errorInvalidFormat();
			return null;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			view.errorInvalidInputNumber();
			return null;
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	
	private Student selectStudentFromID(List<String> data) {
		Student student = null;
		AbstractStudentFactory studFactory = new StudentFactory();
		try 
		{
		    student = studFactory.createStudent(data);
		    view.studentSuccessfullySelected(student.getIdentInfo());
		    studentSelected = true;
		    return student;
		}
		catch (InvalidCountryCodeException e) 
		{
			view.errorInvalidCountryNumber();
		}
		catch (IndexOutOfBoundsException e) 
		{
		    view.errorCorruptedDatabase();
		}
		catch (Exception e) 
		{
		    view.errorUnknownError();
		}
		return null;
	}
}
