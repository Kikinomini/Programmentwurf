package de.dhbw.it2016.pe.PhoneNumberClasses;

public class PhoneNumberZH extends PhoneNumber implements PhoneNumberInterface {
	

	public PhoneNumberZH(String areaCode, String subscriber) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}


	@Override
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		builder.append("+86-");
		builder.append(areaCode);
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
}
