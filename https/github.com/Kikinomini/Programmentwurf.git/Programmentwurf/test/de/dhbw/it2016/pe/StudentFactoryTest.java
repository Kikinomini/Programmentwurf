package de.dhbw.it2016.pe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.dhbw.it2016.pe.AddressClasses.AddressCN;
import de.dhbw.it2016.pe.AddressClasses.AddressDE;
import de.dhbw.it2016.pe.AddressClasses.AddressFN;
import de.dhbw.it2016.pe.AddressClasses.AddressFR;
import de.dhbw.it2016.pe.AddressClasses.AddressUK;
import de.dhbw.it2016.pe.AddressClasses.AddressUS;
import de.dhbw.it2016.pe.AddressClasses.AddressZH;
import de.dhbw.it2016.pe.Exceptions.InvalidCountryCodeException;
import de.dhbw.it2016.pe.Models.Student;
import de.dhbw.it2016.pe.Models.StudentFactory;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberDE;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberFN;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberFR;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberNANP;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberUK;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberZH;

public class StudentFactoryTest {

	@Test
	public void testCreateStudentCN() throws InvalidCountryCodeException {
		
		StudentFactory sFactory = new StudentFactory();
		
		Student student = sFactory.createStudent(createDatalist("CN"));
		
		AddressCN address = new AddressCN("Musterstrasse", "123", "Musterstadt", "12345", "TE");
		PhoneNumberNANP phoneNumber = new PhoneNumberNANP("02323", "1234567890");
		IdentInfo info = new IdentInfo("0", "Max", "Mustermann");
		Student expectedStudent = new Student(info, address, phoneNumber );
		
		assertEquals(expectedStudent.getCompleteName(), student.getCompleteName());
		assertEquals(expectedStudent.getFirstName(), student.getFirstName());
		assertEquals(expectedStudent.getLastName(), student.getLastName());
		assertEquals(expectedStudent.phone(), student.phone());
		assertEquals(expectedStudent.address(), student.address());
		assertEquals(expectedStudent.intlPhone(), student.intlPhone());
	}
	
	@Test
	public void testCreateStudentDE() throws InvalidCountryCodeException {
		
		StudentFactory sFactory = new StudentFactory();
		
		Student student = sFactory.createStudent(createDatalist("DE"));
		
		AddressDE address = new AddressDE("Musterstrasse", "123", "Musterstadt", "12345");
		PhoneNumberDE phoneNumber = new PhoneNumberDE("02323", "1234567890");
		IdentInfo info = new IdentInfo("0", "Max", "Mustermann");
		Student expectedStudent = new Student(info, address, phoneNumber );
		
		assertEquals(expectedStudent.getCompleteName(), student.getCompleteName());
		assertEquals(expectedStudent.getFirstName(), student.getFirstName());
		assertEquals(expectedStudent.getLastName(), student.getLastName());
		assertEquals(expectedStudent.phone(), student.phone());
		assertEquals(expectedStudent.address(), student.address());
		assertEquals(expectedStudent.intlPhone(), student.intlPhone());
	}
	
	@Test
	public void testCreateStudentFN() throws InvalidCountryCodeException {
		
		StudentFactory sFactory = new StudentFactory();
		
		Student student = sFactory.createStudent(createDatalist("FN"));
		
		AddressFN address = new AddressFN("Musterstrasse", "123", "Musterstadt", "12345");
		PhoneNumberFN phoneNumber = new PhoneNumberFN("02323", "1234567890");
		IdentInfo info = new IdentInfo("0", "Max", "Mustermann");
		Student expectedStudent = new Student(info, address, phoneNumber );
		
		assertEquals(expectedStudent.getCompleteName(), student.getCompleteName());
		assertEquals(expectedStudent.getFirstName(), student.getFirstName());
		assertEquals(expectedStudent.getLastName(), student.getLastName());
		assertEquals(expectedStudent.phone(), student.phone());
		assertEquals(expectedStudent.address(), student.address());
		assertEquals(expectedStudent.intlPhone(), student.intlPhone());
	}
	
	@Test
	public void testCreateStudentFR() throws InvalidCountryCodeException {
		
		StudentFactory sFactory = new StudentFactory();
		
		Student student = sFactory.createStudent(createDatalist("FR"));
		
		AddressFR address = new AddressFR("Musterstrasse", "123", "Musterstadt", "12345");
		PhoneNumberFR phoneNumber = new PhoneNumberFR("02323", "1234567890");
		IdentInfo info = new IdentInfo("0", "Max", "Mustermann");
		Student expectedStudent = new Student(info, address, phoneNumber );
		
		assertEquals(expectedStudent.getCompleteName(), student.getCompleteName());
		assertEquals(expectedStudent.getFirstName(), student.getFirstName());
		assertEquals(expectedStudent.getLastName(), student.getLastName());
		assertEquals(expectedStudent.phone(), student.phone());
		assertEquals(expectedStudent.address(), student.address());
		assertEquals(expectedStudent.intlPhone(), student.intlPhone());
	}
	
	@Test
	public void testCreateStudentUK() throws InvalidCountryCodeException {
		
		StudentFactory sFactory = new StudentFactory();
		
		Student student = sFactory.createStudent(createDatalist("UK"));
		
		AddressUK address = new AddressUK("Musterstrasse", "123", "Musterstadt", "12345" );
		PhoneNumberUK phoneNumber = new PhoneNumberUK("02323", "1234567890");
		IdentInfo info = new IdentInfo("0", "Max", "Mustermann");
		Student expectedStudent = new Student(info, address, phoneNumber );
		
		assertEquals(expectedStudent.getCompleteName(), student.getCompleteName());
		assertEquals(expectedStudent.getFirstName(), student.getFirstName());
		assertEquals(expectedStudent.getLastName(), student.getLastName());
		assertEquals(expectedStudent.phone(), student.phone());
		assertEquals(expectedStudent.address(), student.address());
		assertEquals(expectedStudent.intlPhone(), student.intlPhone());
	}
	
	@Test
	public void testCreateStudentUS() throws InvalidCountryCodeException {
		
		StudentFactory sFactory = new StudentFactory();
		
		Student student = sFactory.createStudent(createDatalist("US"));
		
		AddressUS address = new AddressUS("Musterstrasse", "123", "Musterstadt", "12345", "TE");
		PhoneNumberNANP phoneNumber = new PhoneNumberNANP("02323", "1234567890");
		IdentInfo info = new IdentInfo("0", "Max", "Mustermann");
		Student expectedStudent = new Student(info, address, phoneNumber );
		
		assertEquals(expectedStudent.getCompleteName(), student.getCompleteName());
		assertEquals(expectedStudent.getFirstName(), student.getFirstName());
		assertEquals(expectedStudent.getLastName(), student.getLastName());
		assertEquals(expectedStudent.phone(), student.phone());
		assertEquals(expectedStudent.address(), student.address());
		assertEquals(expectedStudent.intlPhone(), student.intlPhone());
	}
	
	@Test
	public void testCreateStudentZH() throws InvalidCountryCodeException {
		
		StudentFactory sFactory = new StudentFactory();
		
		Student student = sFactory.createStudent(createDatalist("ZH"));
		
		AddressZH address = new AddressZH("Musterstrasse", "123", "Musterstadt", "12345", "Test Province");
		PhoneNumberZH phoneNumber = new PhoneNumberZH("02323", "1234567890");
		IdentInfo info = new IdentInfo("0", "Max", "Mustermann");
		Student expectedStudent = new Student(info, address, phoneNumber );
		
		assertEquals(expectedStudent.getCompleteName(), student.getCompleteName());
		assertEquals(expectedStudent.getFirstName(), student.getFirstName());
		assertEquals(expectedStudent.getLastName(), student.getLastName());
		assertEquals(expectedStudent.phone(), student.phone());
		assertEquals(expectedStudent.address(), student.address());
		assertEquals(expectedStudent.intlPhone(), student.intlPhone());
	}
	
	@Test (expected = InvalidCountryCodeException.class) 
	public void testException() throws InvalidCountryCodeException {
		
		StudentFactory sFactory = new StudentFactory();
		
		Student student = sFactory.createStudent(createDatalist("XX"));
		

	}
	
	private List<String> createDatalist(String countryCode) {
		List<String> data = new ArrayList<String>();
		data.add("0");
		data.add("Max");
		data.add("Mustermann");
		data.add("Musterstrasse");
		data.add("123");
		data.add("Musterstadt");
		data.add("12345");
		data.add(countryCode);
		data.add("02323");
		data.add("1234567890");
		
		if(countryCode.equals("CN") || countryCode.equals("US") ){
			data.add("TE");
		}
		else if(countryCode.equals("ZH")){
			data.add("Test Province");
		}
		return data;
	}
}
