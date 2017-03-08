package de.dhbw.it2016.pe.AddressClasses;

public class AddressUK extends AbstractAddressFactory {
	
	public AddressUK(String street, String streetNumber, String city, String zipCode) {
		this.street = street;
		this.streetNumber = streetNumber;		
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public String formatAddress() {
		
		/*
		 * Addresses in the United Kingdom follow the following pattern:
		 * <STREET_NUMBER> <STREET>
		 * <CITY>
		 * United Kingdom
		 */
		
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
