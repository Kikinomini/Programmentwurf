package de.dhbw.it2016.pe.AddressClasses;

public class AddressCN extends AbstractAddress {
	
	private String province;
	
	public AddressCN(String street, String streetNumber, String city, String zipCode, String state) {
		super(street, streetNumber, city, zipCode);
		this.province = state;
	}
	
	/*
	 * Formats addresses for Canada.
	 * Canadian addresses must be in the following format:
	 * <STREET_NUMBER> <STREET>
	 * <CITY>, <STATE> <ZIP_CODE>
	 * Canada
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
		builder.append(province);
		builder.append(" ");
		builder.append(zipCode);
		builder.append(newline);
		
		builder.append("Canada");
		
		return builder.toString();
	}
}	
