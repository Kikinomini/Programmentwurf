package de.dhbw.it2016.pe.StudentClasses;

public abstract class Student {
	// TODO: Transfer common behavior of all Students here [protected?]
	
	protected String id;
	protected String firstName;
	protected String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String info() {
		return id + ": " + firstName + " " + lastName;
	}
}
