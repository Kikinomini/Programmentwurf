package de.dhbw.it2016.pe.AddressClasses;

// Address both used by the US and Canada
public class AddressUS extends Address implements AddressInterface {
	
	private String state;
	
	public AddressUS(String street, String streetNumber, String city, String zipCode, String state) {
		this.street = street;
		this.streetNumber = streetNumber;		
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
	}
	
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
