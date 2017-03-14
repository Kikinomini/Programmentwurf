package de.dhbw.it2016.pe.AddressClasses;

public class AddressFR extends AbstractAddress  {
	
	public AddressFR(String street, String streetNumber, String city, String zipCode) {
		
		// Addresses in France are always in capital letters.
		// Hence street and city must be allocated with the method String.toUpperCase().
		super(street.toUpperCase(), streetNumber, city.toUpperCase(), zipCode);
	}
	
	/*
	 * Formats addresses for France.
	 * French addresses must be in the following format:
	 * <STREET_NUMBER> <STREET> 
	 * <ZIP_CODE> <CITY>
	 * FRANCE
	 */
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
