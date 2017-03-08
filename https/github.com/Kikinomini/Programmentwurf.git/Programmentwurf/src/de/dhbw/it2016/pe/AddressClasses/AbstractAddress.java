package de.dhbw.it2016.pe.AddressClasses;

// Base class of all possible addresses.
// This class is not instantiable because all addresses must be within one country.
public abstract class AbstractAddress {
	
    protected String street;
    protected String streetNumber;
    protected String city;
    protected String zipCode;

    public abstract String formatAddress();
}
