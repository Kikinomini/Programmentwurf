package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	public void testFormat() {
		AddressDE address = new AddressDE("Finkenweg", "1", "Berlin", "12345", "DE");
		String expected = "Finkenweg 1\n12345 Berlin";
		assertEquals(expected, address.format());
	}
}
