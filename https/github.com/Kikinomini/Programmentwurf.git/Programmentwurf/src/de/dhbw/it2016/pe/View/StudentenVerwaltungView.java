package de.dhbw.it2016.pe.View;

// This class creates the views on the console (e.g. string constants).

public final class StudentenVerwaltungView {

	/**************************************************************************
	 * 
	 * Menu views
	 * 
	 **************************************************************************/

	public final void showWelcomeView()
	{
		System.out.println("Welcome to the DHBW Student Management System!");
	}

	public final void showMainMenu()
	{
		System.out.println("What will you do?");
		System.out.println("[1] - Enter a student id:");
		System.out.println("[8] - Exit program");
	}

	public final void showSubMenu()
	{
		System.out.println("What will you do?");
		System.out.println("[2] - Display info");
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[6] - Back");
		System.out.println("[8] - Exit program");
	}
	
	public final void showCloseView()
	{
		System.out.println("Thank you for using the DHBW Student Management System :-)");
	}

	/**************************************************************************
	 * 
	 * Miscellaneous strings
	 * 
	 **************************************************************************/

	public final void enterId()
	{
		System.out.println("Enter id: ");
	}

	public final void studentSuccessfullySelected(final String studentInfo) {
		System.out.println("Successfully selected " + studentInfo);
		
	}

	public final void printArbitraryInputString(final String string)
	{
		System.out.println(string);
	}

	/**************************************************************************
	 * 
	 * Certain error codes and messages
	 * 
	 **************************************************************************/

	public final void errorCorruptedDatabase() {
	    System.out.println("We're sorry, but your database seems to be corrupted.");	    
	}

	public final void errorEmptyDatabase() {
		System.out.println("We're sorry, but your database seems to be empty.");
	}

	public final void errorInvalidCountryNumber()
	{
		System.out.println("We're sorry, but that student's country is not recognized by our servers.");
	}

	public final void errorInvalidFormat()
	{
		System.out.println("Invalid Input!");
	}

	public final void errorInvalidInputNumber()
	{
		System.out.println("Please enter a valid number!");
	}
	
	public final void errorInvalidStudentId() {
		System.out.println("We're sorry, but that student's id is not recognized by our servers.");
		
	}

	public final void errorUnknownError() {
	    System.out.println("Something unexpected went wrong.");
	}
}
