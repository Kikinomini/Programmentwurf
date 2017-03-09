package de.dhbw.it2016.pe.Exceptions;

// Is evoked when the input ID is not 
public final class InvalidInputIDException extends Exception {

	private static final long serialVersionUID = 1L;

    public InvalidInputIDException() { }
    
    public InvalidInputIDException(String message)
    {
        super(message);
    }

    public InvalidInputIDException(Throwable cause)
    {
        super(cause);
    } 

    public InvalidInputIDException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidInputIDException(String message, Throwable cause,
                 boolean enableSuppression, boolean writableStackTrace)
    {
    	super(message, cause, enableSuppression, writableStackTrace);
    }
}