package de.dhbw.it2016.pe.Exceptions;

public class InvalidInputNumberException extends Exception {

	private static final long serialVersionUID = 1L;

    public InvalidInputNumberException() { }
    
    public InvalidInputNumberException(String message)
    {
        super(message);
    }

    public InvalidInputNumberException(Throwable cause)
    {
        super(cause);
    } 

    public InvalidInputNumberException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidInputNumberException(String message, Throwable cause,
                 boolean enableSuppression, boolean writableStackTrace)
    {
    	super(message, cause, enableSuppression, writableStackTrace);
    }
}