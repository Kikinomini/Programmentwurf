package de.dhbw.it2016.pe;

import java.util.List;

import de.dhbw.it2016.pe.AddressClasses.Address;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumber;

public interface AbstractStudentFactory {
	public Address createAddress(List<String> data);
	public PhoneNumber createPhoneNumber();
	public String info();
	public String address();
	public String phone();
	public String intlPhone();
}
