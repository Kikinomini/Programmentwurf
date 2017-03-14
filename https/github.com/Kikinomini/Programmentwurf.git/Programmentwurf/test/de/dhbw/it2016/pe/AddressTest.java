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
		AddressUK address = new AddressUK( "St. Nicholas Street", "10",  "Coventry", "CV1 1JD");
		String expected = "10 St. Nicholas Street\r\n"
				+ "Coventry\r\n"
				+ "CV1 1JD\r\n" 
				+ "United Kingdom";
		assertEquals(expected, address.formatAddress());
	}
	
	@Test
	public void testFormatUS() 
	{
		AddressUS address = new AddressUS( "Spiral Drive", "15", "Florence", "41042", "KY");
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
		AddressCN address = new AddressCN("West Broadway", "1601", "Vancouver", "BC V6J 1W9", "British Columbia");
		String expected = "1601 West Broadway\r\n"
				+ "Vancouver, British Columbia BC V6J 1W9\r\n"
				+ "Canada";
		assertEquals(expected, address.formatAddress());
	}
	
	
	@Test
	public void testFormatZH(){
		AddressZH address = new AddressZH("Ren Min Xi Lu", "203", "Kunming", "123456", "Yunnan");
		String expected = "203 Ren Min Xi Lu, Kunming\r\n"
				+ "123456 Yunnan\r\n"
				+ "People's republic of China";
		assertEquals(expected, address.formatAddress());
	}
}
