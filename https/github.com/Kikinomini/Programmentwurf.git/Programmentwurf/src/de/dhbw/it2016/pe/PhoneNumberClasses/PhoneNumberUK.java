package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberUK extends PhoneNumber {
	

	public PhoneNumberUK(String areaCode, String subscriber) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	

	@Override
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		builder.append("+44-");
		builder.append(areaCode.substring(1));
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}

}
