package de.dhbw.it2016.pe.AddressClasses;

// Address both used by the US and Canada
public class AddressZH implements AddressInterface {
	
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	private String province;
	
	public AddressZH(String street, String streetNumber, String city, String province, String zipCode) {
		this.streetNumber = streetNumber;		
		this.street = street;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
	}
	
	public String formatAddress() {
		String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street);
		builder.append(" ,");
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
