package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.it2016.pe.AddressClasses.AddressDE;

public class AddressTest {

	@Test
	public void testFormat() {
		AddressDE address = new AddressDE("Finkenweg", "11", "Berlin", "12345", "DE");
		String expected = "Finkenweg 11\r\n12345 Berlin";
		assertEquals(expected, address.formatAddress());
	}
}
