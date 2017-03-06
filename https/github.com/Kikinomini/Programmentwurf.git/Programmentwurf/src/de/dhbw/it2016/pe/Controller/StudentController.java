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
		String id = null;
		AbstractStudentFactory studFactory = null;
		MainAction action;
		while (true) {
						
			try {
				this.mainMenu(cin);
			} catch (NumberFormatException e1) {
				view.invalidFormat();
				continue;
			} catch (InvalidCountryCodeException e1) {
				view.invalidCountryNumber();
				continue;
			} catch (InvalidInputNumberException e1) {
				view.InvalidInputNumberException();
				continue;
			}
			
			view.menuView();
			
			String input = cin.readLine();

			try {
				int tsAction = Integer.parseInt(input);
				action = MainAction.values()[tsAction];
			} catch (NumberFormatException e) {
				view.invalidFormat();
				continue;
			}
			
			switch (action) 
			{
			case SearchStudentByID:				
				view.enterId();
				id = cin.readLine();
				List<String> data = readCountryFromStore(id);
				try 
				{
					studFactory =  createStudent(data);
					view.studentSuccessfullySelected(studFactory.getCompleteName());
				}
				catch (InvalidCountryCodeException e) 
				{
					System.out.println("We're sorry, but that student's country is not recognized by our servers.");
				}
				continue;
			
			case DisplayInfo:
				if (studFactory == null) {
					System.out.println("Please search for a student first!");
					continue;
			
				}
				view.printParameter(studFactory.getCompleteName());
				continue;
				
			case DisplayAddress:
				if (studFactory == null) {
					System.out.println("Please search for a student first!");
					continue;
				}
				view.printParameter(studFactory.address());
				continue;
				
			case DisplayPhoneNumber:
				if (studFactory == null) {
					System.out.println("Please search for a student first!");
					continue;
				}
				view.printParameter(studFactory.phone());
				continue;
				
			case DisplayIntlPhoneNumber:
				if (studFactory == null) {
					System.out.println("Please search for a student first!");
					continue;
				}
				view.printParameter(studFactory.intlPhone());
				continue;
				
			case ExitProgram:
				break;
			
			case ErrorCase:
			default:
				view.invalidInputNumber();
				continue;
			}
			
			break;
		}
	}
	
	private void mainMenu(BufferedReader cin) throws IOException, NumberFormatException, 
								InvalidCountryCodeException, InvalidInputNumberException
	{
		view.mainMenu();		
		MainAction action;
		String input = cin.readLine();
		String id = null;
		AbstractStudentFactory studFactory = null;
		
		try {
			int tsAction = Integer.parseInt(input);
			action = MainAction.values()[tsAction];
		} 
		catch (NumberFormatException e) 
		{
			throw new NumberFormatException();
		}
		
		switch (action) 
		{
		case SearchStudentByID:
			
			view.enterId();
			id = cin.readLine();
			List<String> data = readCountryFromStore(id);
			try 
			{
				studFactory =  createStudent(data);
				view.studentSuccessfullySelected(studFactory.getCompleteName());
			}
			catch (InvalidCountryCodeException e) 
			{
				throw new InvalidCountryCodeException();
			}
			
			subMenu(cin, studFactory);
			
		case ExitProgram:
			break;
		default:
			throw new InvalidInputNumberException();
		}
		
	}
	
	private void subMenu(BufferedReader cin, AbstractStudentFactory studFactory) throws IOException, NumberFormatException, InvalidInputNumberException
	{
		view.menuView();
		String input = cin.readLine();
		MainAction action;

		try {
			int tsAction = Integer.parseInt(input);
			action = MainAction.values()[tsAction];
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
		
		switch (action) 
		{
			case DisplayInfo:
				view.printParameter(studFactory.getCompleteName());
			case DisplayAddress:
				view.printParameter(studFactory.address());			
			case DisplayPhoneNumber:
				view.printParameter(studFactory.phone());
			case DisplayIntlPhoneNumber:
				view.printParameter(studFactory.intlPhone());
			case ExitProgram:
				break;
			case ErrorCase:
			default:
				throw new InvalidInputNumberException();
		}
	}
}
