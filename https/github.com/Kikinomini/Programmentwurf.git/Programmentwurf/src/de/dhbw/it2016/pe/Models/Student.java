package de.dhbw.it2016.pe.Models;

import de.dhbw.it2016.pe.IdentInfo;
import de.dhbw.it2016.pe.AddressClasses.AbstractAddress;
import de.dhbw.it2016.pe.PhoneNumberClasses.AbstractPhoneNumber;

// This class represents a concrete student object.
public final class Student {
	
	// The student has three types of information: Identification info (ID + name),
	// An address and a phone number.
	
	private IdentInfo idInfo;
	private AbstractAddress address;
	private AbstractPhoneNumber phone;

	public Student(IdentInfo idInfo, AbstractAddress address, AbstractPhoneNumber phone)
	{
	    this.idInfo = idInfo;
	    this.address = address;
	    this.phone = phone;
	}
	
	public String getFirstName() {
	    return idInfo.getFirstName();
	}

	public String getLastName() {
	    return idInfo.getLastName();
	}
	
	public String getIdentInfo() 
	{	
	    return idInfo.getId() + ": " + idInfo.getFirstName() + " " + idInfo.getLastName();		
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
}