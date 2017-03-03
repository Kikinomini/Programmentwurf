package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.DataStore;
import de.dhbw.it2016.pe.AddressClasses.AddressDE;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberDE;

public class StudentDE implements AbstractStudentFactory{

	private String id;
	private String firstName;
	private String lastName;
	private AddressDE address;
	private PhoneNumberDE phone;

	public StudentDE(String id) {
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
	public AddressDE createAddress() {
		List<String> data = DataStore.read(this.id);
		return new AddressDE(data.get(3), data.get(4), data.get(5),
				data.get(6), data.get(7));
	}

	@Override
	public PhoneNumberDE createPhoneNumber() {
		List<String> data = DataStore.read(this.id);
		return new PhoneNumberDE(data.get(8), data.get(9), data.get(7));
	}

}
