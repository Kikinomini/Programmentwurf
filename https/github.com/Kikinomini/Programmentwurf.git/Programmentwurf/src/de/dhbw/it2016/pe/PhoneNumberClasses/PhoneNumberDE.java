package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberDE implements PhoneNumber{

	private String areaCode;
	private String subscriber;

	public PhoneNumberDE(String areaCode, String subscriber, String country) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	public String formatNational() {
		StringBuilder builder = new StringBuilder();
		builder.append(areaCode);
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
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
