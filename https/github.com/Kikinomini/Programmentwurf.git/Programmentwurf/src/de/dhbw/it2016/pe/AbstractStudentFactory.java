package de.dhbw.it2016.pe;

import java.util.List;

import de.dhbw.it2016.pe.AddressClasses.Address;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberInterface;

public interface AbstractStudentFactory {
	public Address createAddress(List<String> data);
	public PhoneNumberInterface createPhoneNumber(List<String> data);
	public String info();
	public String address();
	public String phone();
	public String intlPhone();
}
