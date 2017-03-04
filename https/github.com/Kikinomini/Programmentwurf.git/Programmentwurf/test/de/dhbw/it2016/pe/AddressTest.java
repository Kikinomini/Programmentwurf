package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.it2016.pe.AddressClasses.*;

public class AddressTest {

	@Test
	public void testFormat() {
		AddressDE address = new AddressDE("Finkenweg", "11", "Berlin", "12345");
		String expected = "Finkenweg 11\r\n12345 Berlin\r\n"
				+ "Germany";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatUK() 
	{
		AddressUK address = new AddressUK("St. Nicholas Street", "10", "Coventry", "CV1 1JD");
		String expected = "10 St. NicholasStreet\r\n"
				+ "Coventry\r\n"
				+ "CV1 1JD\r\n" 
				+ "United Kingdom";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatUS() 
	{
		AddressUS address = new AddressUS("Spiral Drive", "15", "Florence", "KY", "41042");
		String expected = "15 Spiral Drive\r\n"
				+ "Florence, KY 41042"
				+ "United States";
		assertEquals(expected, address.formatAddress());
	}
}
