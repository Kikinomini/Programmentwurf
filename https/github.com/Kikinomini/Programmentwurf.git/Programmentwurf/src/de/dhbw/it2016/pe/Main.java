package de.dhbw.it2016.pe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import de.dhbw.it2016.pe.Controller.StudentController;

public class Main {

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");

		
		String id = null;
		AbstractStudentFactory studFactory = null;
		MainAction action;
		StudentController sController = new StudentController();
		
		while (true) {

			chooseMainAction();

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
				List<String> data = sController.readCountryFromStore(id);
				studFactory =  sController.erzeugeStudent(data);
				System.out.println("Successfully selected " + studFactory.info());
				continue;
				
			// TODO: For all other cases, Exceptions must be handled! 
				
			case DisplayInfo:
				System.out.println(studFactory.info());
				continue;
				
			case DisplayAddress:
				System.out.println(studFactory.address());
				continue;
				
			case DisplayPhoneNumber:
				System.out.println(studFactory.phone());
				continue;
				
			case DisplayIntlPhoneNumber:
				System.out.println(studFactory.intlPhone());
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

	private static void chooseMainAction() {
		System.out.println("What will you do?");
		System.out.println("[1] - Search for student by id");
		System.out.println("[2] - Display info");
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[8] - Exit program");

	}
}
