package de.dhbw.it2016.pe;

// Serves as a helper class for a student's general information (ID + name).

public class IdentInfo {

    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public IdentInfo(String id, String firstName, String lastName) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
    }
}
