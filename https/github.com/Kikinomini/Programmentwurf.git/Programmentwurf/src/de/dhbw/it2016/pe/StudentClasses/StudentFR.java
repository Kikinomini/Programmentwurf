package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.AddressClasses.AddressFR;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberFR;

public class StudentFR extends Student implements AbstractStudentFactory{
	protected AddressFR address;
	protected PhoneNumberFR phone;
	
	public StudentFR(List<String> data) {
		super();
		firstName = data.get(1);
		lastName = data.get(2);
		id = data.get(0);
		address = createAddress(data);
		phone = createPhoneNumber(data);
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

	@Override
	public PhoneNumberFR createPhoneNumber(List<String> data) {
		return new PhoneNumberFR(data.get(8), data.get(9));
	}

	@Override
	public AddressFR createAddress(List<String> data) {
		return new AddressFR(data.get(3), data.get(4), data.get(5),
				data.get(6));
	}
	
	@Override
	public String getCompleteName() 
	{
		return id + ": " + firstName + " " + lastName;		
	}
}
