package de.dhbw.it2016.pe.Exceptions;

public final class InvalidCountryCodeException extends Exception {

	private static final long serialVersionUID = 1L;

    public InvalidCountryCodeException() { }
    
    public InvalidCountryCodeException(String message)
    {
        super(message);
    }

    public InvalidCountryCodeException(Throwable cause)
    {
        super(cause);
    } 

    public InvalidCountryCodeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidCountryCodeException(String message, Throwable cause,
                 boolean enableSuppression, boolean writableStackTrace)
    {
    	super(message, cause, enableSuppression, writableStackTrace);
    }
}
