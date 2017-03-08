package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberUK extends AbstractPhoneNumber {
	

	public PhoneNumberUK(String areaCode, String subscriber) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	/*
	 * Formats a UK international phone number.
     * The country code is +44; the national leading zero is deleted.
	 */
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("+44-");
		builder.append(areaCode.substring(1));
		builder.append("-");
		builder.append(subscriber);
		
		return builder.toString();
	}

}
