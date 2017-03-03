package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.it2016.pe.PhoneNumberClasses.*;

public class PhoneNumberTest {
	@Test
	public void testFormat() {
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
}
