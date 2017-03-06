package de.dhbw.it2016.pe.View;

public class StudentenVerwaltungView {

	public void menuView()
	{
		System.out.println("What will you do?");
		System.out.println("[1] - Display info");
		System.out.println("[2] - Display address");
		System.out.println("[3] - Display phone number");
		System.out.println("[4] - Display int'l phone number");
		System.out.println("[5] - Back");
		System.out.println("[8] - Exit program");
	}
	
	public void mainMenu()
	{
		System.out.println("What will you do?");
		System.out.println("[1] - Enter a studentid:");
		System.out.println("[8] - Exit program");
	}
	
	public void closeView()
	{
		System.out.println("Thank you for using the DHBW Student Management System :-)");
	}
	
	public void invalidInputNumber()
	{
		System.out.println("Please enter a valid number!");
	}
	
	public void invalidFormat()
	{
		System.out.println("Invalid Input!");
	}
	
	public void welcomeView()
	{
		System.out.println("Welcome to the DHBW Student Management System!");
	}

	public void studentSuccessfullySelected(String studentInfo) {
		System.out.println("Successfully selected " + studentInfo);
		
	}
	
	public void enterId()
	{
		System.out.println("Enter id: ");
	}
	
	public void printParameter(String string)
	{
		System.out.println(string);
	}
	
	public void invalidCountryNumber()
	{
		System.out.println("We're sorry, but that student's country is not recognized by our servers.");
	}
	
	public void InvalidInputNumberException()
	{
		System.out.println("We're sorry, but that student's id is not recognized by our servers.");
	}
}
