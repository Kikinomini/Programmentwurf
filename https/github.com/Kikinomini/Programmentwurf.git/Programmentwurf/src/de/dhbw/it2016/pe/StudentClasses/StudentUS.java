package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.AddressClasses.AddressUS;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberUS;

public class StudentUS extends Student implements AbstractStudentFactory {

	protected AddressUS address;
	protected PhoneNumberUS phone;
	
	public StudentUS(String id) {
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
	public AddressUS createAddress() {
		List<String> data = DataStore.read(this.id);
		return new AddressUS(data.get(4), data.get(3), data.get(5),
				data.get(10), data.get(6));
	}

	@Override
	public PhoneNumberUS createPhoneNumber() {
		List<String> data = DataStore.read(this.id);
		return new PhoneNumberUS(data.get(8), data.get(9));
	}
}
