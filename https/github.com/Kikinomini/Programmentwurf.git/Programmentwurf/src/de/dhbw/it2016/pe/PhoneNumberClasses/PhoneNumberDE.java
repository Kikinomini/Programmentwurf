package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberDE extends AbstractPhoneNumberFactory {
	
	public PhoneNumberDE(String areaCode, String subscriber) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		builder.append("+49-");
		builder.append(areaCode.substring(1));
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
	
}
