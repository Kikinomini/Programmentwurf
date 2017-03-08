package de.dhbw.it2016.pe.Models;

import de.dhbw.it2016.pe.IdentInfo;
import de.dhbw.it2016.pe.AddressClasses.AbstractAddress;
import de.dhbw.it2016.pe.PhoneNumberClasses.AbstractPhoneNumber;

public final class Student {
	
	private AbstractAddress address;
	private AbstractPhoneNumber phone;
	private IdentInfo idInfo;

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
	
	public String getCompleteName() 
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

