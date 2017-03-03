package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.AddressClasses.AddressGB;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberGB;

public class StudentGB extends Student implements AbstractStudentFactory {

	protected AddressGB address;
	protected PhoneNumberGB phone;
	
	public StudentGB(List<String> data) {
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
	public AddressGB createAddress(List<String> data) {
		return new AddressGB(data.get(4), data.get(3), data.get(5),
				data.get(6));
	}

	@Override
	public PhoneNumberGB createPhoneNumber(List<String> data) {
		return new PhoneNumberGB(data.get(8), data.get(9));
	}
}