package de.dhbw.it2016.pe;

import java.util.List;

public class StudentDE implements AbstractFactory{

	private String id;
	private String firstName;
	private String lastName;
	private AddressDE address;
	private PhoneNumber phone;

	public StudentDE(String id) {
		readDataFromStore(id);
	}

	public String address() {
		return address.format();
	}

	public String phone() {
		return phone.format();
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
		address = createAddressDE();
		phone = new PhoneNumber(data.get(8), data.get(9), data.get(7));
	}

	@Override
	public AddressDE createAddressDE() {
		List<String> data = DataStore.read(this.id);
		return new AddressDE(data.get(3), data.get(4), data.get(5),
				data.get(6), data.get(7));
	}

}
