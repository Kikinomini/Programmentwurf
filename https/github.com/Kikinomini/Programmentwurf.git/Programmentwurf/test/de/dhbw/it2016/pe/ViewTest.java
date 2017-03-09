package de.dhbw.it2016.pe;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import de.dhbw.it2016.pe.View.StudentenVerwaltungView;

public class ViewTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	public void testCloseView(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.closeView();
		String outputString = outContent.toString();
		assertEquals("Thank you for using the DHBW Student Management System :-)\r\n", outputString);
	}
	
	@Test
	public void testCorruptedDatabase(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.corruptedDatabase();
		String outputString = outContent.toString();
		assertEquals("We're sorry, but your database seems to be corrupted.\r\n", outputString);
	}
	
	@Test
	public void testEnterId(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.enterId();
		String outputString = outContent.toString();
		assertEquals("Enter id: \r\n", outputString);
	}
	
	@Test
	public void testInvalidCountryNumber(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.invalidCountryNumber();
		String outputString = outContent.toString();
		assertEquals("We're sorry, but that student's country is not recognized by our servers.\r\n", outputString);
	}
	
	@Test
	public void testInvalidFormat(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.invalidFormat();
		String outputString = outContent.toString();
		assertEquals("Invalid Input!\r\n", outputString);
	}
	
	@Test
	public void testInvalidInputNumber(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.invalidInputNumber();
		String outputString = outContent.toString();
		assertEquals("Please enter a valid number!\r\n", outputString);
	}
	
	@Test
	public void testInvalidStudentId(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.invalidStudentId();
		String outputString = outContent.toString();
		assertEquals("We're sorry, but that student's id is not recognized by our servers.\r\n", outputString);
	}
	
	@Test
	public void testMenuView(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.menuView();
		String outputString = outContent.toString();
		assertEquals("What will you do?\r\n"
				+ "[2] - Display info\r\n"
				+ "[3] - Display address\r\n"
				+ "[4] - Display phone number\r\n"
				+ "[5] - Display int'l phone number\r\n"
				+ "[6] - Back\r\n"
				+ "[8] - Exit program\r\n", outputString);
	}
	
	@Test
	public void testPrintParameter(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.printParameter("Hallo");
		String outputString = outContent.toString();
		assertEquals("Hallo\r\n", outputString);
	}
	
	@Test
	public void testShowMainMenu(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.showMainMenu();
		String outputString = outContent.toString();
		assertEquals("What will you do?\r\n"
					+ "[1] - Enter a studentid:\r\n"
					+ "[8] - Exit program\r\n", outputString);
	}
	
	@Test
	public void testStudentSuccessfullySelected(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.studentSuccessfullySelected("TestStudent");
		String outputString = outContent.toString();
		assertEquals("Successfully selected TestStudent\r\n", outputString);
	}
	
	@Test
	public void testUnknownError(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.unknownError();
		String outputString = outContent.toString();
		assertEquals("Something unexpected went wrong.\r\n", outputString);
	}
	
	@Test
	public void testWelcomeView(){
		System.setOut(new PrintStream(outContent));
		StudentenVerwaltungView view = new StudentenVerwaltungView();
		view.welcomeView();
		String outputString = outContent.toString();
		assertEquals("Welcome to the DHBW Student Management System!\r\n", outputString);
	}
}
