package de.dhbw.it2016.pe.Model;

import java.util.List;

import de.dhbw.it2016.pe.Exceptions.InvalidCountryCodeException;

public abstract class AbstractStudentFactory {
	
	public abstract Student createStudent(List<String> data) throws InvalidCountryCodeException;

	
}
