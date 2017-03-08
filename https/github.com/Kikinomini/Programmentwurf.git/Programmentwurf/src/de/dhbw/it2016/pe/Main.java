package de.dhbw.it2016.pe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import de.dhbw.it2016.pe.Controller.StudentController;

public class Main {
    
    private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {		
		StudentController sController = new StudentController();	
		sController.manageMainMenu(cin);
		cin.close();
    }
}
