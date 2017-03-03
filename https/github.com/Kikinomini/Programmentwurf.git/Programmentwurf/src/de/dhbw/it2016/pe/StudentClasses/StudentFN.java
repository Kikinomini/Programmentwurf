package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.AddressClasses.Address;
import de.dhbw.it2016.pe.AddressClasses.AddressDE;
import de.dhbw.it2016.pe.AddressClasses.AddressFN;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumber;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberDE;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberFN;

public class StudentFN extends Student implements AbstractStudentFactory {

	protected AddressFN address;
	protected PhoneNumberFN phone;
	
	public StudentFN(List<String> data) {
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
	public PhoneNumberFN createPhoneNumber(List<String> data) {
		return new PhoneNumberFN(data.get(8), data.get(9));
	}

	@Override
	public AddressFN createAddress(List<String> data) {
		return new AddressFN(data.get(3), data.get(4), data.get(5),
				data.get(6));
	}
}
