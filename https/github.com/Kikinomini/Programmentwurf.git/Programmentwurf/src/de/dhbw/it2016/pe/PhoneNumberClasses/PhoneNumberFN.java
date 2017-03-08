package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberFN extends AbstractPhoneNumber {


	public PhoneNumberFN(String areaCode, String subscriber) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	/*
	 * Formats a Finnish international phone number.
     * The country code is +358; the national leading zero is deleted.
	 */
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("+358-");
		builder.append(areaCode.substring(LEADING_ZERO_SKIP));
		builder.append("-");
		builder.append(subscriber);
		
		return builder.toString();
	}
}
