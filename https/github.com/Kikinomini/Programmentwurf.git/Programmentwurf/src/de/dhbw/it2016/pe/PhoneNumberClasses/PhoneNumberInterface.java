package de.dhbw.it2016.pe.PhoneNumberClasses;

public interface PhoneNumberInterface {
	
	public String formatNational();
	public String formatInternational();

	// NOTE: Pay attention with the international format. Not every country has a leading zero.
	// p.e. America lacks it (phone numbers start with the 3-digit state code)
}
