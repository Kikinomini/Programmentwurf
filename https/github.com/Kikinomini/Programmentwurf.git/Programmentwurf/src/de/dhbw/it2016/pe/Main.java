package de.dhbw.it2016.pe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import de.dhbw.it2016.pe.StudentClasses.StudentDE;

public class Main {

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");

		AbstractStudentFactory studFactory;
		String id = null;
		StudentDE student = null;
		MainAction action;
		
		while (true) {

			whatWillYouDo();

			String input = cin.readLine();

			try {
				int tsAction = Integer.parseInt(input);
				action = MainAction.values()[tsAction];
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input!");
				continue;
			}

			switch (action) 
			{
			case SearchStudentByID:
				System.out.println("Enter id: ");
				id = cin.readLine();
				student = new StudentDE(id);
				System.out.println("Successfully selected " + student.info());
				continue;
				
			// TODO: For all other cases, Exceptions must be handled! 
				
			case DisplayInfo:
				System.out.println(student.info());
				continue;
				
			case DisplayAddress:
				System.out.println(student.address());
				continue;
				
			case DisplayPhoneNumber:
				System.out.println(student.phone());
				continue;
				
			case DisplayIntlPhoneNumber:
				System.out.println(student.intlPhone());
				continue;
				
			case ExitProgram:
				break;
			
			case ErrorCase:
			default:
				System.out.println("Please enter a valid number!");
				continue;
			}
			
			break;
		}

		System.out.println("Thank you for using the DHBW Student Management System :-)");

		cin.close();
	}

	private static void whatWillYouDo() {
		System.out.println("What will you do?");
		System.out.println("[1] - Search for student by id");
		System.out.println("[2] - Display info");
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[8] - Exit program");

	}
}
