package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberFR implements PhoneNumber {

	private String areaCode;
	private String subscriber;

	public PhoneNumberFR(String areaCode, String subscriber) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	@Override
	public String formatNational() {
		StringBuilder builder = new StringBuilder();
		builder.append(areaCode);
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}

	@Override
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		builder.append("+33-");
		builder.append(areaCode.substring(1));
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
}
