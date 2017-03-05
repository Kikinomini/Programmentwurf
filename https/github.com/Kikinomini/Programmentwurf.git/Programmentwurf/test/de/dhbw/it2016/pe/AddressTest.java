package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.it2016.pe.AddressClasses.*;

public class AddressTest {

	@Test
	public void testFormatDE() {
		AddressDE address = new AddressDE("Finkenweg", "11", "Berlin", "12345");
		String expected = "Finkenweg 11\r\n12345 Berlin\r\n"
				+ "Germany";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatUK() 
	{
		AddressUK address = new AddressUK( "10", "St. Nicholas Street", "Coventry", "CV1 1JD");
		String expected = "10 St. Nicholas Street\r\n"
				+ "Coventry\r\n"
				+ "CV1 1JD\r\n" 
				+ "United Kingdom";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatUS() 
	{
		AddressUS address = new AddressUS( "15", "Spiral Drive", "Florence", "KY", "41042");
		String expected = "15 Spiral Drive\r\n"
				+ "Florence, KY 41042\r\n"
				+ "United States";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatFR()
	{
		AddressFR address = new AddressFR("Rue Barbet de Jouy", "16", "Paris", "75007");
		String expected = "16 RUE BARBET DE JOUY\r\n"
				+ "75007 PARIS\r\n"
				+ "FRANCE";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatFN()
	{
		AddressFN address = new AddressFN("Ämmänkatu", "5", "Suomussalmi", "89600");
		String expected = "Ämmänkatu 5\r\n"
				+ "89600 Suomussalmi\r\n"
				+ "Finland";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatCA(){
		AddressCA address = new AddressCA("1601", "West Broadway", "Vancouver", "British Columbia", "BC V6J 1W9");
		String expected = "1601 West Broadway\r\n"
				+ "Vancouver, British Columbia BC V6J 1W9\r\n"
				+ "Canada";
		assertEquals(expected, address.formatAddress());
	}
}
