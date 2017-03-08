package de.dhbw.it2016.pe.AddressClasses;

public class AddressFN extends AbstractAddressFractory {
	
	public AddressFN(String street, String streetNumber, String city, String zipCode) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
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
