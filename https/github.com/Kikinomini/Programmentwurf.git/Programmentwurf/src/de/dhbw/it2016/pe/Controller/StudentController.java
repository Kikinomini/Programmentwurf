package de.dhbw.it2016.pe.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.MainMenuSelector;
import de.dhbw.it2016.pe.Exceptions.*;
import de.dhbw.it2016.pe.Models.*;
import de.dhbw.it2016.pe.View.StudentenVerwaltungView;

public class StudentController {
	
	private StudentenVerwaltungView view = new StudentenVerwaltungView();
		
	public List<String> readDataFromStore(String id)
	{
		List<String> data = DataStore.read(id);
		return data;
	}
	
	public void closeView()
	{
		view.closeView();
	}
	
	public void welcomeView()
	{
		view.welcomeView();
	}
	
	public void manageMainMenu(BufferedReader cin) throws IOException, NullPointerException
	{
		boolean closeProgramm = false;
		do {
			view.showMainMenu();		
			MainMenuSelector action = null;
			String input = cin.readLine();
			String id = null;
			Student student = null;
			StudentFactory studFactory = new StudentFactory();
			
			try {
				int tsAction = Integer.parseInt(input);
				action = MainMenuSelector.values()[tsAction];
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
			
			switch (action) 
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
				    closeProgramm = this.subMenu(cin, student, studentSelected, closeProgramm, action);
				} catch (InvalidInputNumberException e) {
					view.invalidInputNumber();
				}	
				break;
				
			case ExitProgram:
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
					
				case ExitProgram:
					closeProgramm = true;
					break;
					
				case Back:
					studentSelected = false;
					break;
					
				default:
					view.invalidFormat();
					break;
			}
		} while (studentSelected == true && closeProgramm == false);
		
		return closeProgramm;
	}
	
}
