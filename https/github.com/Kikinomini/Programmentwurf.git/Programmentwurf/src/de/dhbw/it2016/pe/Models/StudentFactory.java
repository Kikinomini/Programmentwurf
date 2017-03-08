package de.dhbw.it2016.pe.Models;

import java.util.List;

import de.dhbw.it2016.pe.CSVColumnManager;
import de.dhbw.it2016.pe.IdentInfo;
import de.dhbw.it2016.pe.AddressClasses.*;
import de.dhbw.it2016.pe.Exceptions.InvalidCountryCodeException;
import de.dhbw.it2016.pe.PhoneNumberClasses.*;

public class StudentFactory extends AbstractStudentFactory {
	public Student createStudent(List<String> data) throws InvalidCountryCodeException {
		
		Student student;
		
		// The column manager sets a list of constants for the communication with the .csv file.
		CSVColumnManager info = new CSVColumnManager();
		
		IdentInfo idInfo = new IdentInfo(
			data.get(info.STUDENT_ID),
			data.get(info.FIRST_NAME),
			data.get(info.LAST_NAME));
		
		String country = data.get(info.COUNTRY_CODE);
		
		switch (country) 
		{		
			case "CN":
				AbstractAddress address = new AddressUS(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						 data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumber phone = new PhoneNumberNANP(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, address, phone);
				return student;

			case "DE":	
				AbstractAddress addressDE = new AddressDE(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						data.get(info.ZIP_CODE));
				AbstractPhoneNumber phoneDE = new PhoneNumberDE(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressDE, phoneDE);
				return student;
				
			case "FN":
				AbstractAddress addressFN = new AddressFN(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						data.get(info.ZIP_CODE));
				AbstractPhoneNumber phoneFN = new PhoneNumberFN(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressFN, phoneFN);
				return student;
			
			case "FR":	
				AbstractAddress addressFR = new AddressFR(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						data.get(info.ZIP_CODE));
				AbstractPhoneNumber phoneFR = new PhoneNumberFR(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressFR, phoneFR);
				return student;

			case "UK":
				AbstractAddress addressUK = new AddressUK(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						data.get(info.ZIP_CODE));
				AbstractPhoneNumber phoneUK = new PhoneNumberUK(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressUK, phoneUK);
				return student;

			case "US":
				AbstractAddress addressUS = new AddressUS(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						 data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumber phoneUS = new PhoneNumberNANP(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressUS, phoneUS);
				return student;
			
			case "ZH": // Create a new Chinese student
				AbstractAddress addressZH = new AddressZH(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						 data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumber phoneZH = new PhoneNumberZH(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressZH, phoneZH);
				return student;
			
			default:
				throw new InvalidCountryCodeException();
		}
		
	}
}
