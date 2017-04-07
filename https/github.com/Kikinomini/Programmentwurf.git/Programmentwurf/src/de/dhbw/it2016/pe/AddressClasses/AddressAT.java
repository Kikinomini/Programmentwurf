package de.dhbw.it2016.pe.AddressClasses;

public class AddressAT extends AbstractAddress {

	public AddressAT(String street, String streetNumber, String city, String zipCode) {
		super(street, streetNumber, city, zipCode);
	}
	
	/*
	 * Formats addresses for Austria.
	 * Austrian addresses must be in the following format:
	 * <STREET> <STREET_NUMBER>
	 * <ZIP_CODE> <CITY>
	 * Austria
	 */
	public String formatAddress() {
		String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		
		builder.append(street);
		builder.append(" ");
		builder.append(streetNumber);
		builder.append(newline);

		builder.append(zipCode);
		builder.append(" ");
		builder.append(city);
		
		builder.append("Austria");
		return builder.toString();
	}
}