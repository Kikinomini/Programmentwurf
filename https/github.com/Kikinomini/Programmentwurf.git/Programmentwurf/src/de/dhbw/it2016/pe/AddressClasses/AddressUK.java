package de.dhbw.it2016.pe.AddressClasses;

public class AddressUK extends AbstractAddress {
	
	public AddressUK(String street, String streetNumber, String city, String zipCode) {
		super(street, streetNumber, city, zipCode);
	}
	
	/*
	 * Formats addresses for the United Kingdom.
	 * Addresses in the UK must be in the following format:
	 * <STREET_NUMBER> <STREET>
	 * <CITY>
	 * United Kingdom
	 */
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
