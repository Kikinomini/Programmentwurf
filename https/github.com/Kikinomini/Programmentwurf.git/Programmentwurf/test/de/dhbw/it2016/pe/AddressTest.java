package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test
	public void testFormat() {
		Address address = new Address("Finkenweg", "1", "Berlin", "12345", "DE");
		String expected = "Finkenweg 1\n12345 Berlin";
		assertEquals(expected, address.format());
	}

}
