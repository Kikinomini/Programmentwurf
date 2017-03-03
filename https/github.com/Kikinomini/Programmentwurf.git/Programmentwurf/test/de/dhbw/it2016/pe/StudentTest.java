package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.it2016.pe.StudentClasses.*;

public class StudentTest {

	@Test
	public void TestName() 
	{
		StudentDE cloneStudent = new StudentDE("6");
		
		String firstName = cloneStudent.getFirstName();
		assertEquals("Sarah", firstName);
		
		String lastName = cloneStudent.getLastName();
		assertEquals("Manning", lastName);
	}
}
