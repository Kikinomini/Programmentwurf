package de.dhbw.it2016.pe.AddressClasses;

// Address both used by the US and Canada
public class AddressUS extends AbstractAddress {
	
	private String state;
	
	public AddressUS(String street, String streetNumber, String city, String zipCode, String state) {
		super(street, streetNumber, city, zipCode);
		this.state = state;
	}
	
	/*
	 * Formats addresses for the United States of America.
	 * American addresses must be in the following format:
	 * <STREET_NUMBER> <STREET>
	 * <CITY>, <STATE> <ZIP_CODE>
	 * United States
	 */
	public String formatAddress() {
		String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street);
		builder.append(newline);
		builder.append(city);
		builder.append(", ");
		builder.append(state);
		builder.append(" ");
		builder.append(zipCode);
		builder.append(newline);
		builder.append("United States");
		return builder.toString();

	}
}	
