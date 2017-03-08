package de.dhbw.it2016.pe.AddressClasses;

public abstract class AbstractAddressFractory {
	
	    protected String street;
	    protected String streetNumber;
	    protected String city;
	    protected String zipCode;

	    public abstract String formatAddress();



}
