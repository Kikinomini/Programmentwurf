package de.dhbw.it2016.pe.Controller;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.StudentClasses.StudentDE;
import de.dhbw.it2016.pe.StudentClasses.StudentFN;
import de.dhbw.it2016.pe.StudentClasses.StudentGB;
import de.dhbw.it2016.pe.StudentClasses.StudentUS;

public class StudentController {
		
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

}
