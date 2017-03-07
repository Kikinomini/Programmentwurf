package de.dhbw.it2016.pe;

import java.util.List;

import de.dhbw.it2016.pe.AddressClasses.Address;
import de.dhbw.it2016.pe.AddressClasses.AddressDE;
import de.dhbw.it2016.pe.AddressClasses.AddressFN;
import de.dhbw.it2016.pe.AddressClasses.AddressFR;
import de.dhbw.it2016.pe.AddressClasses.AddressUK;
import de.dhbw.it2016.pe.AddressClasses.AddressUS;
import de.dhbw.it2016.pe.AddressClasses.AddressZH;
import de.dhbw.it2016.pe.Exceptions.InvalidCountryCodeException;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumber;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberDE;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberFN;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberFR;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberNANP;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberUK;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberZH;
import de.dhbw.it2016.pe.StudentClasses.Student;

public class AbstractStudentFactory {
	
	public Student createStudent(List<String> data) throws InvalidCountryCodeException {
		
		Student student;
		String country = data.get(7);
		
		switch (country) 
		{		
			case "CN":
				Address address = new AddressUS(data.get(3), data.get(4), data.get(5),
						 data.get(6), data.get(10));
				PhoneNumber phone = new PhoneNumberNANP(data.get(8), data.get(9));
				student = new Student(address, phone, data);
				return student;
			case "DE":
				Address addressDE = new AddressDE(data.get(3), data.get(4), data.get(5),
						data.get(6));
				PhoneNumber phoneDE = new PhoneNumberDE(data.get(8), data.get(9));
				student = new Student(addressDE, phoneDE, data);
				return student;
			case "FN":
				Address addressFN = new AddressFN(data.get(3), data.get(4), data.get(5),
						data.get(6));
				PhoneNumber phoneFN = new PhoneNumberFN(data.get(8), data.get(9));
				student = new Student(addressFN, phoneFN, data);
				return student;
			case "FR":
				Address addressFR = new AddressFR(data.get(3), data.get(4), data.get(5),
						data.get(6));
				PhoneNumber phoneFR = new PhoneNumberFR(data.get(8), data.get(9));
				student = new Student(addressFR, phoneFR, data);
				return student;
			case "UK":
				Address addressUK = new AddressUK(data.get(3), data.get(4), data.get(5),
						data.get(6));
				PhoneNumber phoneUK = new PhoneNumberUK(data.get(8), data.get(9));
				student = new Student(addressUK, phoneUK, data);
				return student;
			case "US":
				Address addressUS = new AddressUS(data.get(3), data.get(4), data.get(5),
						 data.get(6), data.get(10));
				PhoneNumber phoneUS = new PhoneNumberNANP(data.get(8), data.get(9));
				student = new Student(addressUS, phoneUS, data);
				return student;
			case "ZH":
				Address addressZH = new AddressZH(data.get(3), data.get(4), data.get(5),
						 data.get(6), data.get(10));
				PhoneNumber phoneZH = new PhoneNumberZH(data.get(8), data.get(9));
				student = new Student(addressZH, phoneZH, data);
				return student;
			default:
				throw new InvalidCountryCodeException();
		}
		
	}
}
