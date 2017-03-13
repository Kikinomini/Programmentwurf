package de.dhbw.it2016.pe;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import de.dhbw.it2016.pe.View.StudentManagementView;

public class ViewTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	public void testCloseView(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.showCloseView();
		String outputString = outContent.toString();
		assertEquals("Thank you for using the DHBW Student Management System :-)\r\n", outputString);
	}
	
	@Test
	public void testCorruptedDatabase(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.errorCorruptedDatabase();
		String outputString = outContent.toString();
		assertEquals("We're sorry, but your database seems to be corrupted.\r\n", outputString);
	}
	
	@Test
	public void testEnterId(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.enterId();
		String outputString = outContent.toString();
		assertEquals("Enter id: \r\n", outputString);
	}
	
	@Test
	public void testInvalidCountryNumber(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.errorInvalidCountryNumber();
		String outputString = outContent.toString();
		assertEquals("We're sorry, but that student's country is not recognized by our servers.\r\n", outputString);
	}
	
	@Test
	public void testInvalidFormat(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.errorInvalidFormat();
		String outputString = outContent.toString();
		assertEquals("Invalid Input!\r\n", outputString);
	}
	
	@Test
	public void testInvalidInputNumber(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.errorInvalidInputNumber();
		String outputString = outContent.toString();
		assertEquals("Please enter a valid number!\r\n", outputString);
	}
	
	@Test
	public void testInvalidStudentId(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.errorInvalidStudentId();
		String outputString = outContent.toString();
		assertEquals("We're sorry, but that student's id is not recognized by our servers.\r\n", outputString);
	}
	
	@Test
	public void testMenuView(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.showMainMenu();
		String outputString = outContent.toString();
		assertEquals("What will you do?\r\n"
				+ "[1] - Enter ID of another student\r\n"
				+ "[2] - Display info\r\n"
				+ "[3] - Display address\r\n"
				+ "[4] - Display phone number\r\n"
				+ "[5] - Display int'l phone number\r\n"
				+ "[8] - Exit program\r\n", outputString);
	}
	
	@Test
	public void testPrintParameter(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.printUserData("Hallo");
		String outputString = outContent.toString();
		assertEquals("Hallo\r\n", outputString);
	}
	
	@Test
	public void testShowMainMenu(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.showInitialMenu();
		String outputString = outContent.toString();
		assertEquals("What will you do?\r\n"
					+ "[1] - Enter a student ID\r\n"
					+ "[8] - Exit program\r\n", outputString);
	}
	
	@Test
	public void testStudentSuccessfullySelected(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.studentSuccessfullySelected("TestStudent");
		String outputString = outContent.toString();
		assertEquals("Successfully selected TestStudent\r\n", outputString);
	}
	
	@Test
	public void testUnknownError(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.errorUnknownError();
		String outputString = outContent.toString();
		assertEquals("Something unexpected went wrong.\r\n", outputString);
	}
	
	@Test
	public void testWelcomeView(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.showWelcomeView();
		String outputString = outContent.toString();
		assertEquals("Welcome to the DHBW Student Management System!\r\n", outputString);
	}
	
	@Test
	public void testErrorEmptyDatabase(){
		System.setOut(new PrintStream(outContent));
		StudentManagementView view = new StudentManagementView();
		view.errorEmptyDatabase();
		String outputString = outContent.toString();
		assertEquals("We're sorry, but your database seems to be empty.\r\n", outputString);
	}
}
