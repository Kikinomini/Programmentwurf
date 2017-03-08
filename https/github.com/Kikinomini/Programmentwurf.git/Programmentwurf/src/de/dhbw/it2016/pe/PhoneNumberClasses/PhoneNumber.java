package de.dhbw.it2016.pe.PhoneNumberClasses;

public abstract class PhoneNumber {
	
	protected String areaCode;
    protected String subscriber;

    public String formatNational() {
        StringBuilder builder = new StringBuilder();
        builder.append(areaCode);
        builder.append("-");
        builder.append(subscriber);
        return builder.toString();
    }

    public abstract String formatInternational();
}
