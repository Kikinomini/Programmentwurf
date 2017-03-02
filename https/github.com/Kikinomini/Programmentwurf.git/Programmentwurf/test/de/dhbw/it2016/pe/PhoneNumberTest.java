package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneNumberTest {
	@Test
	public void testFormat() {
		PhoneNumberDE phone = new PhoneNumberDE("01234", "56789", "DE");
		String expected = "01234-56789";
		assertEquals(expected, phone.format());
	}

	@Test
	public void testFormatInternational() {
		PhoneNumberDE phone = new PhoneNumberDE("01234", "56789", "DE");
		String expected = "+49-1234-56789";
		assertEquals(expected, phone.format());
	}

}
