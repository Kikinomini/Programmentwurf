package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.AddressClasses.AddressDE;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberDE;

public class StudentDE extends Student implements AbstractStudentFactory{

	protected AddressDE address;
	protected PhoneNumberDE phone;
	
	public StudentDE(List<String> data) {
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
	public PhoneNumberDE createPhoneNumber(List<String> data) {
		return new PhoneNumberDE(data.get(8), data.get(9));
	}

	@Override
	public AddressDE createAddress(List<String> data) {
		return new AddressDE(data.get(3), data.get(4), data.get(5),
				data.get(6));
	}

}
