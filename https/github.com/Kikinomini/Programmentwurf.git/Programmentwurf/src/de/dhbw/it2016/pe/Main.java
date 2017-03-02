package de.dhbw.it2016.pe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");

		String id = null;
		
		Student student = null;
		
		while (true) {

			whatWillYouDo();

			String input = cin.readLine();

			MainAction action;

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
				student = new Student(id);
				System.out.println("Successfully selected " + student.info());
				continue;
				
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
			case ErrorCase:
			default:
				break;
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
