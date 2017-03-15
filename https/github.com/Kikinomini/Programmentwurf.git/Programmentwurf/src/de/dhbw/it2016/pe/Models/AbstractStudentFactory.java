package de.dhbw.it2016.pe.Models;

import java.util.List;

import de.dhbw.it2016.pe.Exceptions.InvalidCountryCodeException;

// This class serves as base class for all concrete factories. Reserved for further purposes.
public abstract class AbstractStudentFactory {
	
	public abstract Student createStudent(List<String> data) throws InvalidCountryCodeException;
}
