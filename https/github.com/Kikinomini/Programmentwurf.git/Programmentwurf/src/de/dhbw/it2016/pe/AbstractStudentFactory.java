package de.dhbw.it2016.pe;

import java.util.List;

import de.dhbw.it2016.pe.AddressClasses.AddressInterface;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberInterface;

public interface AbstractStudentFactory {
	public AddressInterface createAddress(List<String> data);
	public PhoneNumberInterface createPhoneNumber(List<String> data);
	public String info();
	public String address();
	public String phone();
	public String intlPhone();
}
