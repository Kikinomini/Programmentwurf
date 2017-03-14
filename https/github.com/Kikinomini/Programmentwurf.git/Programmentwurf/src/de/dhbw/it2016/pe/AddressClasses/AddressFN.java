package de.dhbw.it2016.pe.AddressClasses;

public class AddressFN extends AbstractAddress {
	
	public AddressFN(String street, String streetNumber, String city, String zipCode) {
		super(street, streetNumber, city, zipCode);
	}

	/*
	 * Formats addresses for Finland.
	 * Finnish addresses must be in the following format:
	 * <STREET> <STREET_NUMBER>
	 * <ZIP_CODE> <CITY>
	 * Finland
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
		builder.append(newline);

		builder.append("Finland");
		
		return builder.toString();
	}

}
