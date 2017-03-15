package de.dhbw.it2016.pe.View;

// This class creates the views on the console (e.g. string constants).

public final class StudentManagementView {

	/**************************************************************************
	 * 
	 * Menu views
	 * 
	 **************************************************************************/

	public final void showWelcomeView() {
		System.out.println("Welcome to the DHBW Student Management System!");
	}

	public final void showInitialMenu() {
		System.out.println("What will you do?");
		System.out.println("[1] - Enter a student ID");
		System.out.println("[8] - Exit program");
	}

	public final void showMainMenu() {
		System.out.println("What will you do?");
		System.out.println("[1] - Enter ID of another student");
		System.out.println("[2] - Display info");
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[8] - Exit program");
	}
	
	public final void showCloseView() {
		System.out.println("Thank you for using the DHBW Student Management System :-)");
	}

	/**************************************************************************
	 * 
	 * Miscellaneous strings
	 * 
	 **************************************************************************/

	public final void enterId() {
		System.out.println("Enter id: ");
	}

	// This string prints the user data as the programer has specified.
	public final void printUserData(final String string) {
		System.out.println(string);
	}
	
	public final void studentSuccessfullySelected(final String studentInfo) {
		System.out.println("Successfully selected " + studentInfo);
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

	public final void errorInvalidCountryNumber() {
		System.out.println("We're sorry, but that student's country is not recognized by our servers.");
	}

	public final void errorInvalidFormat() {
		System.out.println("Invalid Input!");
	}

	public final void errorInvalidInputNumber() {
		System.out.println("Please enter a valid number!");
	}
	
	public final void errorInvalidStudentId() {
		System.out.println("We're sorry, but that student's id is not recognized by our servers.");
	}

	public final void errorUnknownError() {
	    System.out.println("Something unexpected went wrong.");
	}
	
	public final void errorIOExcetion() {
	    System.out.println("We're sorry, but something went wrong while enter an Input.");
	}
}
