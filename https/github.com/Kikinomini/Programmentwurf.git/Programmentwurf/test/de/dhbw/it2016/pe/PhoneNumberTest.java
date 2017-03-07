package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.it2016.pe.PhoneNumberClasses.*;

public class PhoneNumberTest {
	@Test
	public void testFormatNationalGermany() {
		PhoneNumberDE phone = new PhoneNumberDE("01234", "56789");
		String expected = "01234-56789";
		assertEquals(expected, phone.formatNational());
	}

	@Test
	public void testFormatInternationalGermany() {
		PhoneNumberDE phone = new PhoneNumberDE("01234", "56789");
		String expected = "+49-1234-56789";
		assertEquals(expected, phone.formatInternational());
	}
	
	@Test
	public void testFormatInternationalFinland() 
	{
		PhoneNumberFN phone = new PhoneNumberFN("09", "458580");
		String expected = "+358-9-458580";
		assertEquals(expected, phone.formatInternational());
	}
	
	@Test
	public void testFormatNationalFinland() {
		PhoneNumberFN phone = new PhoneNumberFN("09", "458580");
		String expected = "09-458580";
		assertEquals(expected, phone.formatNational());
	}
	
	@Test
	public void testFormatInternationalFrance() 
	{
		PhoneNumberFR phone = new PhoneNumberFR("01", "369852");
		String expected = "+33-1-369852";
		assertEquals(expected, phone.formatInternational());
	}
	
	@Test
	public void testFormatNationalFrance() {
		PhoneNumberFR phone = new PhoneNumberFR("01", "369852");
		String expected = "01-369852";
		assertEquals(expected, phone.formatNational());
	}
	
	@Test
	public void testFormatInternationalUK() 
	{
		PhoneNumberUK phone = new PhoneNumberUK("0121", "147852");
		String expected = "+44-121-147852";
		assertEquals(expected, phone.formatInternational());
	}
	
	@Test
	public void testFormatNationalUK() {
		PhoneNumberUK phone = new PhoneNumberUK("0121", "147852");
		String expected = "0121-147852";
		assertEquals(expected, phone.formatNational());
	}
	
	@Test
	public void testFormatInternationalUS() 
	{
		PhoneNumberNANP phone = new PhoneNumberNANP("212-423", "1753");
		String expected = "+1-212-423-1753";
		assertEquals(expected, phone.formatInternational());
	}
	
	@Test
	public void testFormatNationalUS() {
		PhoneNumberNANP phone = new PhoneNumberNANP("212-423", "1753");
		String expected = "212-423-1753";
		assertEquals(expected, phone.formatNational());
	}
	
	@Test
	public void testFormatInternationalZH() 
	{
		PhoneNumberZH phone = new PhoneNumberZH("10", "654987");
		String expected = "+86-10-654987";
		assertEquals(expected, phone.formatInternational());
	}
	
	@Test
	public void testFormatNationalZH() {
		PhoneNumberZH phone = new PhoneNumberZH("10", "654987");
		String expected = "10-654987";
		assertEquals(expected, phone.formatNational());
	}	
}
