package de.dhbw.it2016.pe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import de.dhbw.it2016.pe.Controller.StudentController;

// Serves as main entry point of the application.
public class Main {
    
    private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {	
    	
    	// A student controller manages the execution of the program.
		StudentController sController = new StudentController();	
		sController.manageInitialMenu(cin);
		
		// Close reader after program execution
		cin.close();
    }
}
