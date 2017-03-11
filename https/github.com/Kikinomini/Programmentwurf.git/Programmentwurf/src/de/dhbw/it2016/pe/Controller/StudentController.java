package de.dhbw.it2016.pe.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.MainMenuSelector;
import de.dhbw.it2016.pe.Exceptions.*;
import de.dhbw.it2016.pe.Models.*;
import de.dhbw.it2016.pe.View.StudentManagementView;

/* Manages the entire behavior of the program,
 * i.e. the administration of the menus.
 */
public class StudentController {

	/***************************************************************************************
	 * 
	 * Class variables
	 * 
	****************************************************************************************/

	// Serves as interface to the main output device (e.g. the console).
	private StudentManagementView view = new StudentManagementView();

	// Stores the last input from the console.
	private String consoleInput;

	// The enumeration "userSelection" displays a user's choice.
	MainMenuSelector userSelection = null;
	
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
	
	/* 
	 * This menu is shown before the first student is selected. 
	 * The user cannot do anything else apart from selecting a user by ID and closing the program.
	 */
	public void manageInitialMenu(BufferedReader cin) throws IOException, NullPointerException
	{
		Student student = null;

		do {
			// Loading the initial screen
			view.showWelcomeView();
			view.showInitialMenu();		

			// The string variable consoleInput stores the next input from the console.
			consoleInput = cin.readLine();

			// Let the user select an option by input of an ID from the console,
			// continue if valid, and return to loop head, if invalid
			userSelection = getUserSelectionFromInputStream();
			if (userSelection == null) {
				continue;
			}
			
			// From here on, the user input will be processed (if it was valid).
			switch (userSelection) {		
				case SearchStudentByID:
					student = searchStudentByID(cin);
					
					// If a student has been successfully selected, the actual menu
					// with further options is evoked. 
					try {
						this.manageMainMenu(cin, student);
					} 
					catch (InvalidInputIDException e) {
						view.errorInvalidInputNumber();
					}	
					
					// If the main menu is closed, the program will be exited.
					break;
					
				case ExitProgram:
					view.showCloseView();
					break;
					
				default:
					view.errorInvalidInputNumber();
					continue;
			}
			// If the initial menu is closed instantly, the program will be exited too.
			break;
		} while (true);	
	}

	/* 
	 * This menu is shown as soon as the first student is selected. 
	 * The user can search for another student by ID
	 */
	private void manageMainMenu(BufferedReader cin, Student student) throws InvalidInputIDException, IOException 
	{
		do {
			view.showMainMenu();
			consoleInput = cin.readLine();

			// Select a user by input of an ID from the console
			userSelection = getUserSelectionFromInputStream();
			if (userSelection == null) {
				continue;
			}
			
			// From here on, the user input will be processed (if it was valid).
			switch (userSelection) 
			{
				// Searches for another student (i.e. repeats the initial selection)
				case SearchStudentByID:
					student = searchStudentByID(cin);
					continue;
					
				// Displays some basic information of the selected student.
				case DisplayInfo:
					view.printUserData(student.getIdentInfo());
					continue;
					
				// Displays the address of the selected student.
				case DisplayAddress:
					view.printUserData(student.address());	
					continue;

				// Displays the national phone number of the selected student.
				case DisplayPhoneNumber:
					view.printUserData(student.phone());
					continue;

				// Displays the international phone number of the selected student.
				case DisplayIntlPhoneNumber:
					view.printUserData(student.intlPhone());
					continue;

				// If [8] is pressed, the do-while-loop is left and the program is exited.
				case ExitProgram:
					view.showCloseView();
					break;	

				// In case of an irregular input, the program will just continue.
				default:
					view.errorInvalidFormat();
					continue;
			}
			break;
		} while (true);
	}
	
	/*
	 * This method lets the user select a menu option.
	 * Returns a MainMenuSelector enumerator, if a correct selection has been taken,
	 * or null, if the selection was invalid.
	 */
	private MainMenuSelector getUserSelectionFromInputStream() {
		try {
			int tempUserSelection = Integer.parseInt(consoleInput);
			return MainMenuSelector.values()[tempUserSelection];
		} 
		catch (NumberFormatException e) {
			view.errorInvalidFormat();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			view.errorInvalidInputNumber();
		}
		catch (Exception e) {
			view.errorUnknownError();
		}
		return null;
	}
	
	/*
	 * This method lets the user select an ID from which a student can be loaded.
	 * The method continues until a valid student has been loaded.
	 */
	private Student searchStudentByID(BufferedReader cin) throws IOException {
		Student student = null;
		String id = null;
		AbstractStudentFactory studFactory = new StudentFactory();
		
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
			try {
			    student = studFactory.createStudent(data);
			    view.studentSuccessfullySelected(student.getIdentInfo());
			    
			    return student;
			}
			catch (InvalidCountryCodeException e) {
				view.errorInvalidCountryNumber();
			}
			catch (IndexOutOfBoundsException e) {
			    view.errorCorruptedDatabase();
			}
			catch (Exception e) {
			    view.errorUnknownError();
			}
			
			// If student was not loaded successfully (i.e. is not selected),
			// the do while loop continues.
		} while(student == null);
		return student;
	}
}
