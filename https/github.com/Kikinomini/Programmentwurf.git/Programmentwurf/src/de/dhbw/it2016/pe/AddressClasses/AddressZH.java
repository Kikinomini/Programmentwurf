package de.dhbw.it2016.pe.AddressClasses;

// Address both used by the US and Canada
public class AddressZH extends AbstractAddress {
	
	private String province;
	
	public AddressZH(String street, String streetNumber, String city, String zipCode, String province) {
		super(street, streetNumber, city, zipCode);
		this.province = province;
	}
	
	/*
	 * Formats addresses for mainland China (excluding Hongkong and Macau).
	 * Chinese addresses must be in the following format:
	 * <STREET_NUMBER> <STREET>, <CITY>
	 * <ZIP_CODE> <PROVINCE>
	 * People's republic of China
	 */
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
