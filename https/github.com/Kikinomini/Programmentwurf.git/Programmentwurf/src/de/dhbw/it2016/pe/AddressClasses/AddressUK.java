package de.dhbw.it2016.pe.AddressClasses;

public class AddressUK extends Address implements AddressInterface {
	
	public AddressUK(String streetNumber, String street, String city, String zipCode) {
		this.streetNumber = streetNumber;		
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public String formatAddress() {
		String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street);
		builder.append(newline);
		builder.append(city);
		builder.append(newline);
		builder.append(zipCode);
		builder.append(newline);
		builder.append("United Kingdom");

		return builder.toString();
	}
}
