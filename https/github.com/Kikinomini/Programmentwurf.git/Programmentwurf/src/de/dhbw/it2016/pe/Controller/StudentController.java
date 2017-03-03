package de.dhbw.it2016.pe.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.MainAction;
import de.dhbw.it2016.pe.StudentClasses.StudentDE;
import de.dhbw.it2016.pe.StudentClasses.StudentFN;
import de.dhbw.it2016.pe.StudentClasses.StudentGB;
import de.dhbw.it2016.pe.StudentClasses.StudentUS;
import de.dhbw.it2016.pe.View.StudentenVerwaltungView;

public class StudentController {
	
	private StudentenVerwaltungView view = new StudentenVerwaltungView();
		
	public List<String> readCountryFromStore(String id)
	{
		List<String> data = DataStore.read(id);
		return data;
	}
	
	public AbstractStudentFactory erzeugeStudent(List<String> data)
	{
		String country = data.get(7);
		if(country.equals("DE"))
		{
			AbstractStudentFactory student = new StudentDE(data);
			return student;
		}
		else if(country.equals("FN"))
		{
			AbstractStudentFactory student = new StudentFN(data);
			return student;
		}
		else if(country.equals("US"))
		{
			AbstractStudentFactory student = new StudentUS(data);
			return student;
		}
		else if(country.equals("GB"))
		{
			AbstractStudentFactory student = new StudentGB(data);
			return student;
		}
		return null;
	}
	
	public void closeView()
	{
		view.closeView();
	}
	
	public void welcomeView()
	{
		view.welcomeView();
	}
	
	public void programmLogik(BufferedReader cin) throws IOException
	{
		String id = null;
		AbstractStudentFactory studFactory = null;
		MainAction action;
		while (true) {

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
				studFactory =  erzeugeStudent(data);
				view.studentSelect(studFactory.info());
				continue;
				
			// TODO: For all other cases, Exceptions must be handled! 
				
			case DisplayInfo:
				view.printParameter(studFactory.info());
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
				break;
			
			case ErrorCase:
			default:
				view.invalidInputNumber();
				continue;
			}
			
			break;
		}
	}

}
