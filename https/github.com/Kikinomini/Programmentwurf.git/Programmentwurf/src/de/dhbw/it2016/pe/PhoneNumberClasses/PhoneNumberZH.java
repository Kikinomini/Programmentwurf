package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberZH extends AbstractPhoneNumber {
	

	public PhoneNumberZH(String areaCode, String subscriber) {
		super(areaCode, subscriber);
	}

	/*
	 * Formats a mainland Chinese international phone number (excluding Hongkong and Macau)
     * The country code is +86; there is no national leading zero.
	 */
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("+86-");
		builder.append(areaCode);
		builder.append("-");
		builder.append(subscriber);
		
		return builder.toString();
	}
}
