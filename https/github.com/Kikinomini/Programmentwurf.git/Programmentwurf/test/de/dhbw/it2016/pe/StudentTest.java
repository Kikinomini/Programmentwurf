package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import de.dhbw.it2016.pe.Controller.StudentController;
import de.dhbw.it2016.pe.StudentClasses.*;

public class StudentTest {

	@Test
	public void TestName() 
	{
		StudentController sController = new StudentController();
		List<String> data = sController.readCountryFromStore("6");
		StudentDE cloneStudent = (StudentDE) sController.createStudent(data);
		
		String firstName = cloneStudent.getFirstName();
		assertEquals("Sarah", firstName);
		
		String lastName = cloneStudent.getLastName();
		assertEquals("Manning", lastName);
	}
}
