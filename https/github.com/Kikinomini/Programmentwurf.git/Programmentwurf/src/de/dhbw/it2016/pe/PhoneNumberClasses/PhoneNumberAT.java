    package de.dhbw.it2016.pe.PhoneNumberClasses;

	public class PhoneNumberAT extends AbstractPhoneNumber {
	
	public PhoneNumberAT(String areaCode, String subscriber) {
		super(areaCode, subscriber);
	}
	
	/*
	 * Formats an Austrian international phone number.
     * The country code is +43; the national leading zero is deleted.
	 */
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();

		builder.append("+43-");
		builder.append(areaCode.substring(LEADING_ZERO_SKIP));
		builder.append("-");
		builder.append(subscriber);
		
		return builder.toString();
	}
}
