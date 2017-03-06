package de.dhbw.it2016.pe.AddressClasses;

// Address both used by the US and Canada
public class AddressUS extends Address implements AddressInterface {
	
	private String state;
	
	public AddressUS(String streetNumber, String street, String city, String state, String zipCode) {
		this.streetNumber = streetNumber;		
		this.street = street;
		this.city = city;
		this.state = state;
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
		builder.append(", ");
		builder.append(state);
		builder.append(" ");
		builder.append(zipCode);
		builder.append(newline);
		builder.append("United States");
		return builder.toString();

	}
}	
