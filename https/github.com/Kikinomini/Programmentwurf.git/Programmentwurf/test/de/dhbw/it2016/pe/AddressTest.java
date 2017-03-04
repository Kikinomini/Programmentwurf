package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.it2016.pe.AddressClasses.*;

public class AddressTest {

	@Test
	public void testFormat() {
		AddressDE address = new AddressDE("Finkenweg", "11", "Berlin", "12345");
		String expected = "Finkenweg 11\r\n12345 Berlin";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatUK() 
	{
		AddressUK address = new AddressUK("St. Nicholas Street", "10", "Coventry", "CV1 1JD");
		String expected = "10 St. NicholasStreet\r\n"
				+ "CV1 1JD Coventry";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatUS() 
	{
		AddressUK address = new AddressUK("St. Nicholas Street", "10", "Coventry", "CV1 1JD");
		String expected = "15 Spiral Drive\r\n"
				+ "CV1 1JD Coventry";
		assertEquals(expected, address.formatAddress());
	}
}
