package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.AddressClasses.AddressUS;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberUS;

public class StudentUS extends Student implements AbstractStudentFactory {

	protected AddressUS address;
	protected PhoneNumberUS phone;
	
	public StudentUS(List<String> data) {
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
	public AddressUS createAddress(List<String> data) {
		return new AddressUS(data.get(4), data.get(3), data.get(5),
				data.get(10), data.get(6));
	}

	@Override
	public PhoneNumberUS createPhoneNumber(List<String> data) {
		return new PhoneNumberUS(data.get(8), data.get(9));
	}
}