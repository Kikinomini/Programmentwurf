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
	
	// Serves as interface to the main output device.
	private StudentenVerwaltungView view = new StudentenVerwaltungView();
		
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
		boolean closeProgramm = false;
		do {
			
			// Loading the initial screen
			view.welcomeView();
			view.showMainMenu();		

			StudentFactory studFactory = new StudentFactory();
			String input = cin.readLine();

			// The enumeration "userSelection" displays a user's choice.
			MainMenuSelector userSelection = null;
			String id = null;
			Student student = null;
			
			
			try {
				int tempUserSelection = Integer.parseInt(input);
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
				boolean studentSelected = false;
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
					    view.studentSuccessfullySelected(student.getCompleteName());
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
				    closeProgramm = this.subMenu(cin, student, studentSelected, closeProgramm, userSelection);
				} catch (InvalidInputNumberException e) {
					view.invalidInputNumber();
				}	
				break;
				
			case ExitProgram:
				view.closeView();
				closeProgramm = true;
				break;
				
			default:
				view.invalidInputNumber();
				continue;
			}
		} while (closeProgramm == false);	
	}

	private boolean subMenu(BufferedReader cin, Student student, boolean studentSelected, boolean closeProgramm, MainMenuSelector action) throws InvalidInputNumberException, IOException 
	{
		do{
			view.menuView();
			String input = cin.readLine();

			try {
				int tsAction = Integer.parseInt(input);
				action = MainMenuSelector.values()[tsAction];
			} catch (NumberFormatException e) {
				view.invalidFormat();
				continue;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				view.invalidFormat();
				continue;
			}
			
			switch (action) 
			{
				case DisplayInfo:
					view.printParameter(student.getCompleteName());
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
					closeProgramm = true;
					break;	
					
				default:
					view.invalidFormat();
					break;
			}
		} while (studentSelected == true && closeProgramm == false);
		
		return closeProgramm;
	}	
}
