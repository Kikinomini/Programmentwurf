package de.dhbw.it2016.pe;

public class AddressDE implements Address{

	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	public AddressDE(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public String format() {
		String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append(street);
		builder.append(" ");
		builder.append(streetNumber);
		builder.append(newline);
		builder.append(zipCode);
		builder.append(" ");
		builder.append(city);
		return builder.toString();
	}

}
