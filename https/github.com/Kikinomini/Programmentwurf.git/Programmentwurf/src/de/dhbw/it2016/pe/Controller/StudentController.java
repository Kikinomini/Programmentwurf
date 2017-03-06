package de.dhbw.it2016.pe.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.MainAction;
import de.dhbw.it2016.pe.Exceptions.*;
import de.dhbw.it2016.pe.StudentClasses.*;
import de.dhbw.it2016.pe.View.StudentenVerwaltungView;

public class StudentController {
	
	private StudentenVerwaltungView view = new StudentenVerwaltungView();
		
	public List<String> readCountryFromStore(String id)
	{
		List<String> data = DataStore.read(id);
		return data;
	}
	
	public AbstractStudentFactory createStudent(List<String> data) throws InvalidCountryCodeException
	{
		AbstractStudentFactory student;
		String country = data.get(7);
		
		switch (country) 
		{
			case "CN":
				student = new StudentCN(data);
				return student;
				
			case "DE":
				student = new StudentDE(data);
				return student;
				
			case "FN":
				student = new StudentFN(data);
				return student;
				
			case "FR":
				student = new StudentFR(data);
				return student; //TEST
				
			case "UK":
				student = new StudentUK(data);
				return student;
				
			case "US":
				student = new StudentUS(data);
				return student;
				
			case "ZH":
				student = new StudentZH(data);
				return student;
			
			default:
				throw new InvalidCountryCodeException();
		}
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
			view.mainMenu();		
			MainAction action = null;
			String input = cin.readLine();
			String id = null;
			AbstractStudentFactory studFactory = null;
			
			try {
				int tsAction = Integer.parseInt(input);
				action = MainAction.values()[tsAction];
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
					List<String> data = readCountryFromStore(id);
					if(data.isEmpty())
					{
						view.invalidStudentId();
						continue;
					}
					try 
					{
						studFactory =  createStudent(data);
						view.studentSuccessfullySelected(studFactory.getCompleteName());
						studentSelected = true;
					}
					catch (InvalidCountryCodeException e) 
					{
						view.invalidCountryNumber();
						continue;
					}
				}while(studentSelected == false);
				try {
					this.subMenu(cin, studFactory, studentSelected, closeProgramm, action);
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
		}while(closeProgramm == false);	
	}
	
	private void subMenu(BufferedReader cin, AbstractStudentFactory studFactory, boolean studentSelected, boolean closeProgramm, MainAction action) throws InvalidInputNumberException, IOException 
	{
		do{
			view.menuView();
			String input = cin.readLine();

			try {
				int tsAction = Integer.parseInt(input);
				action = MainAction.values()[tsAction];
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
					view.printParameter(studFactory.getCompleteName());
					continue;
				case DisplayAddress:
					view.printParameter(studFactory.address());	
					continue;
				case DisplayPhoneNumber:
					view.printParameter(studFactory.phone());
					continue;
				case DisplayIntlPhoneNumber:
					view.printParameter(studFactory.intlPhone());
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
		}while(studentSelected == true && closeProgramm == false);
	}
}
