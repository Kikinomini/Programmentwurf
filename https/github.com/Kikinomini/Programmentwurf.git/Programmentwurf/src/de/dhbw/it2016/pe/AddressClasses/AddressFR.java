package de.dhbw.it2016.pe.AddressClasses;

public class AddressFR implements AddressInterface {
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	public AddressFR(String street, String streetNumber, String city, String zipCode) {
		this.street = street.toUpperCase();
		this.streetNumber = streetNumber;
		this.city = city.toUpperCase();
		this.zipCode = zipCode;
	}
	
	public String formatAddress() {
		String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street);
		builder.append(newline);
		builder.append(zipCode);
		builder.append(" ");
		builder.append(city);
		builder.append(newline);
		builder.append("FRANCE");
		return builder.toString();
	}
}
