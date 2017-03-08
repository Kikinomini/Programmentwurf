package de.dhbw.it2016.pe.AddressClasses;

// Address both used by the US and Canada
public class AddressZH extends Address {
	
	private String province;
	
	public AddressZH(String street, String streetNumber, String city, String zipCode, String province) {
		this.street = street;
		this.streetNumber = streetNumber;		
		this.city = city;
		this.zipCode = zipCode;
		this.province = province;
	}
	
	public String formatAddress() {
		String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street);
		builder.append(", ");
		builder.append(city);
		builder.append(newline);
		builder.append(zipCode);
		builder.append(" ");
		builder.append(province);
		builder.append(newline);
		builder.append("People's republic of China");
		return builder.toString();
	}
}	
