package de.dhbw.it2016.pe.AddressClasses;

public class AddressGB implements Address {
	
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;

	
	public AddressGB(String streetNumber, String street, String city, String zipCode) {
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
		return builder.toString();

	}

}
