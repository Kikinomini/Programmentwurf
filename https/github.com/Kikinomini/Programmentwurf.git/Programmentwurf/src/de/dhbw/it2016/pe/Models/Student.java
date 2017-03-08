package de.dhbw.it2016.pe.Models;

import de.dhbw.it2016.pe.IdentInfo;
import de.dhbw.it2016.pe.AddressClasses.AbstractAddressFactory;
import de.dhbw.it2016.pe.PhoneNumberClasses.AbstractPhoneNumberFactory;

public final class Student {
	
	private AbstractAddressFactory address;
	private AbstractPhoneNumberFactory phone;
	private IdentInfo idInfo;

	public Student(IdentInfo idInfo, AbstractAddressFactory address, AbstractPhoneNumberFactory phone)
	{
	    this.idInfo = idInfo;
	    this.address = address;
	    this.phone = phone;
	}
	
	public String getFirstName() {
	    return idInfo.firstName;
	}

	public String getLastName() {
	    return idInfo.lastName;
	}
	
	public String getCompleteName() 
	{
	    return idInfo.id + ": " + idInfo.firstName + " " + idInfo.lastName;		
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

