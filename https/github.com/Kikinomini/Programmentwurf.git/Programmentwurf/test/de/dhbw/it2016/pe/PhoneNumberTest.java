package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberDE;

public class PhoneNumberTest {
	@Test
	public void testFormat() {
		PhoneNumberDE phone = new PhoneNumberDE("01234", "56789", "DE");
		String expected = "01234-56789";
		assertEquals(expected, phone.formatNational());
	}

	@Test
	public void testFormatInternational() {
		PhoneNumberDE phone = new PhoneNumberDE("01234", "56789", "DE");
		String expected = "+49-1234-56789";
		assertEquals(expected, phone.formatInternational());
	}

}
