package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberFR extends AbstractPhoneNumber {


	public PhoneNumberFR(String areaCode, String subscriber) {
		super(areaCode, subscriber);
	}
	
	/*
	 * Formats a French international phone number.
     * The country code is +33; the national leading zero is deleted.
	 */
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
	
		builder.append("+33-");
		builder.append(areaCode.substring(LEADING_ZERO_SKIP));
		builder.append("-");
		builder.append(subscriber);
		
		return builder.toString();
	}
}
