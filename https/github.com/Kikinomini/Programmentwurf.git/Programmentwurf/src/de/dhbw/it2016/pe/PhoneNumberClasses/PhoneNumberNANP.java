package de.dhbw.it2016.pe.PhoneNumberClasses;

/*
 * The North American Numbering Plan (NANP) is a telephone numbering plan that encompasses 
 * 25 distinct regions in twenty countries primarily in North America, including the Caribbean 
 * and the U.S. territories. Not all North American countries participate in the NANP. (Wikipedia)
 */

public class PhoneNumberNANP extends AbstractPhoneNumber {


	public PhoneNumberNANP(String areaCode, String subscriber) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	/*
	 * Formats an international phone number for a member of the NANP.
     * The country code is +1; there is no leading zero.
	 */
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("+1-");
		builder.append(areaCode);
		builder.append("-");
		builder.append(subscriber);
		
		return builder.toString();
	}
}
