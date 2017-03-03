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
	
	public StudentFN(String id) {
		readDataFromStore(id);
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String info() {
		return id + ": " + firstName + " " + lastName;
	}

	private void readDataFromStore(String id) {
		List<String> data = DataStore.read(id);
		this.id = id;
		firstName = data.get(1);
		lastName = data.get(2);
		address = createAddress();
		phone = createPhoneNumber();
	}

	@Override
	public AddressFN createAddress() {
		List<String> data = DataStore.read(this.id);
		return new AddressFN(data.get(3), data.get(4), data.get(5),
				data.get(6), data.get(7));
	}

	@Override
	public PhoneNumberFN createPhoneNumber() {
		List<String> data = DataStore.read(this.id);
		return new PhoneNumberFN(data.get(8), data.get(9), data.get(7));
	}
}
