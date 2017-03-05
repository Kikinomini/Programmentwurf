package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.AddressClasses.AddressUK;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberUK;

public class StudentUK extends Student implements AbstractStudentFactory {

	protected AddressUK address;
	protected PhoneNumberUK phone;
	
	public StudentUK(List<String> data) {
		super();
		firstName = data.get(1);
		lastName = data.get(2);
		address = createAddress(data);
		phone = createPhoneNumber(data);
		id = data.get(0);
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
	public AddressUK createAddress(List<String> data) {
		return new AddressUK(data.get(4), data.get(3), data.get(5),
				data.get(6));
	}

	@Override
	public PhoneNumberUK createPhoneNumber(List<String> data) {
		return new PhoneNumberUK(data.get(8), data.get(9));
	}
	
	@Override
	public String getCompleteName() 
	{
		return id + ": " + firstName + " " + lastName;		
	}
}
