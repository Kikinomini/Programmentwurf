package de.dhbw.it2016.pe;

import de.dhbw.it2016.pe.AddressClasses.Address;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumber;

public interface AbstractStudentFactory {
	public Address createAddress();
	public PhoneNumber createPhoneNumber();
}
