package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
	@Test
	public void testInternationalPhone()
	{
		StudentDE helsinkiStudent = new StudentDE("5");
		
		String TelNr = helsinkiStudent.intlPhone();
		assertEquals("+358-1141-941115", TelNr);
	}
}
