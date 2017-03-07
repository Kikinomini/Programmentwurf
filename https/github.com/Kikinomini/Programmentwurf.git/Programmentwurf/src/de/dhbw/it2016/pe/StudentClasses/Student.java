package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AddressClasses.Address;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumber;


public class Student {
	
	protected String id;
	protected String firstName;
	protected String lastName;
	protected Address address;
	protected PhoneNumber phone;
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String address() {
		return address.formatAddress();
	}

	public String phone() {
		return phone.formatNational();
	}
	
	public String intlPhone() {
		return phone.formatInternational();
	}
	
	public String getCompleteName() 
	{
		return id + ": " + firstName + " " + lastName;		
	}
	
	public Student(Address address, PhoneNumber phone, List<String> data)
	{
		firstName = data.get(1);
		lastName = data.get(2);
		this.address = address;
		this.phone = phone;
		id = data.get(0);
	}
}

