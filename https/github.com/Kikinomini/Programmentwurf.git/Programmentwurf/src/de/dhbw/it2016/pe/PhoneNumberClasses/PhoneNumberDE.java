package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberDE extends AbstractPhoneNumber {
	
	public PhoneNumberDE(String areaCode, String subscriber) {
		super(areaCode, subscriber);
	}
	
	/*
	 * Formats a German international phone number.
     * The country code is +49; the national leading zero is deleted.
	 */
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();

		builder.append("+49-");
		builder.append(areaCode.substring(LEADING_ZERO_SKIP));
		builder.append("-");
		builder.append(subscriber);
		
		return builder.toString();
	}
	
}
