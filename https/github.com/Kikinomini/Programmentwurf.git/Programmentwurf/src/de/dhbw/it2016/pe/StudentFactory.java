package de.dhbw.it2016.pe;

import java.util.List;

import de.dhbw.it2016.pe.AddressClasses.*;
import de.dhbw.it2016.pe.Exceptions.InvalidCountryCodeException;
import de.dhbw.it2016.pe.PhoneNumberClasses.*;
import de.dhbw.it2016.pe.StudentClasses.Student;

public class StudentFactory {
	
	public Student createStudent(List<String> data) throws InvalidCountryCodeException {
		
		Student student;
		
		// The column manager sets a list of constants for the communication with the .csv file.
		CSVColumnManager info = new CSVColumnManager();
		String country = data.get(info.COUNTRY_CODE);
		
		switch (country) 
		{		
			case "CN":
				AbstractAddressFractory address = new AddressUS(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						 data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumberFactory phone = new PhoneNumberNANP(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(address, phone, data);
				return student;

			case "DE":	
				AbstractAddressFractory addressDE = new AddressDE(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						data.get(info.ZIP_CODE));
				AbstractPhoneNumberFactory phoneDE = new PhoneNumberDE(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(addressDE, phoneDE, data);
				return student;
				
			case "FN":
				AbstractAddressFractory addressFN = new AddressFN(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						data.get(info.ZIP_CODE));
				AbstractPhoneNumberFactory phoneFN = new PhoneNumberFN(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(addressFN, phoneFN, data);
				return student;
			
			case "FR":	
				AbstractAddressFractory addressFR = new AddressFR(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						data.get(info.ZIP_CODE));
				AbstractPhoneNumberFactory phoneFR = new PhoneNumberFR(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(addressFR, phoneFR, data);
				return student;

			case "UK":
				AbstractAddressFractory addressUK = new AddressUK(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						data.get(info.ZIP_CODE));
				AbstractPhoneNumberFactory phoneUK = new PhoneNumberUK(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(addressUK, phoneUK, data);
				return student;

			case "US":
				AbstractAddressFractory addressUS = new AddressUS(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						 data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumberFactory phoneUS = new PhoneNumberNANP(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(addressUS, phoneUS, data);
				return student;
			
			case "ZH": // Create a new Chinese student
				AbstractAddressFractory addressZH = new AddressZH(data.get(info.STREET), data.get(info.STREET_NUMBER), data.get(info.CITY),
						 data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumberFactory phoneZH = new PhoneNumberZH(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(addressZH, phoneZH, data);
				return student;
			
			default:
				throw new InvalidCountryCodeException();
		}
		
	}
}
