package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberUS implements PhoneNumber {

	private String areaCode;
	private String subscriber;

	public PhoneNumberUS(String areaCode, String subscriber) {
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
		builder.append("+1-");
		builder.append(areaCode);
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
}
