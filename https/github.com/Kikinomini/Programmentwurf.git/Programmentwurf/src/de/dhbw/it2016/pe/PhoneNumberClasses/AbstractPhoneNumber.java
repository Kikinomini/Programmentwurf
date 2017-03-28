package de.dhbw.it2016.pe.PhoneNumberClasses;

//Base class of all possible phone numbers.
//This class is not instantiable because all phone numbers must correspond to one country.
public abstract class AbstractPhoneNumber {
	
	protected String areaCode;
    protected String subscriber;
    
    /* 
     * If this constant is appended, one digit of the national number
     * (e.g. the leading zero in many countries) is skipped.
     * This is not a glitch used for speedruns.
     */
    protected final byte LEADING_ZERO_SKIP = 1;
    
    /* 
     * Formats a national phone number. (i.e. returns the database information)
     *
     * The national format is the plain string from the database;
     * Adjust the international format instead of this method.
     */
    
	protected AbstractPhoneNumber(String areaCode, String subscriber) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
    public final String formatNational() {
        StringBuilder builder = new StringBuilder();
        
        builder.append(areaCode);
        builder.append("-");
        builder.append(subscriber);
        
        return builder.toString();
    }
    
    public abstract String formatInternational();
}
