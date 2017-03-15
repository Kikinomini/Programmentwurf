package de.dhbw.it2016.pe.Models;

import java.util.List;

import de.dhbw.it2016.pe.CSVColumnManager;
import de.dhbw.it2016.pe.IdentInfo;
import de.dhbw.it2016.pe.AddressClasses.*;
import de.dhbw.it2016.pe.Exceptions.InvalidCountryCodeException;
import de.dhbw.it2016.pe.PhoneNumberClasses.*;

/*
 * This class serves as a factory for student objects.
 */

public class StudentFactory extends AbstractStudentFactory {
	
	public Student createStudent(List<String> data) throws InvalidCountryCodeException {		
		Student student;
		
		// The column manager sets a list of constants for the communication with the .csv file.
		CSVColumnManager info = new CSVColumnManager();
	
		// Within the idInfo object, the general information of a student is stored (i.e. ID + name)
		IdentInfo idInfo = new IdentInfo(
			data.get(info.STUDENT_ID),
			data.get(info.FIRST_NAME),
			data.get(info.LAST_NAME));
		
		// By means of the country code, a concrete student matching that country can be created.
		String country = data.get(info.COUNTRY_CODE);
		
		/*
		 * A concrete student is created with a specific address class (e.g. an instance of AddressDE for Germany)
		 * and with a specific phone number class (e.g. an instance of PhoneNumberUS for an American student)
		 * The concrete student itself does not know which phone number is associated with him (i.e. the object has no memory)
		 */
		
		switch (country) {
			// Student from Canada
			case "CN":
				AbstractAddress addressCN = new AddressCN(data.get(info.STREET_NUMBER), data.get(info.STREET),
						data.get(info.CITY), data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumber phone = new PhoneNumberNANP(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressCN, phone);
				return student;

			// Student from Germany
			case "DE":	
				AbstractAddress addressDE = new AddressDE(data.get(info.STREET), data.get(info.STREET_NUMBER),
						data.get(info.CITY), data.get(info.ZIP_CODE));
				AbstractPhoneNumber phoneDE = new PhoneNumberDE(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressDE, phoneDE);
				return student;

			// Student from Finland
			case "FN":
				AbstractAddress addressFN = new AddressFN(data.get(info.STREET), data.get(info.STREET_NUMBER),
						data.get(info.CITY), data.get(info.ZIP_CODE));
				AbstractPhoneNumber phoneFN = new PhoneNumberFN(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressFN, phoneFN);
				return student;
			
			// Student from France
			case "FR":	
				AbstractAddress addressFR = new AddressFR(data.get(info.STREET), data.get(info.STREET_NUMBER),
						data.get(info.CITY), data.get(info.ZIP_CODE));
				AbstractPhoneNumber phoneFR = new PhoneNumberFR(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressFR, phoneFR);
				return student;

			// Student from the United Kingdom
			case "UK":
				AbstractAddress addressUK = new AddressUK(data.get(info.STREET), data.get(info.STREET_NUMBER),
						data.get(info.CITY), data.get(info.ZIP_CODE));
				AbstractPhoneNumber phoneUK = new PhoneNumberUK(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressUK, phoneUK);
				return student;

			// Student from the United States
			case "US":
				AbstractAddress addressUS = new AddressUS(data.get(info.STREET), data.get(info.STREET_NUMBER),
						data.get(info.CITY), data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumber phoneUS = new PhoneNumberNANP(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressUS, phoneUS);
				return student;
			
			// Student from mainland China (without Hongkong and Macau)
			case "ZH":
				AbstractAddress addressZH = new AddressZH(data.get(info.STREET), data.get(info.STREET_NUMBER),
						data.get(info.CITY), data.get(info.ZIP_CODE), data.get(info.PROVINCE_OPTIONAL));
				AbstractPhoneNumber phoneZH = new PhoneNumberZH(data.get(info.PHONE_AREA_CODE), data.get(info.PHONE_SUBSCRIBER));
				student = new Student(idInfo, addressZH, phoneZH);
				return student;
			
			/*
			 * If the country code specified is not recognized by this application,
			 * the user will get an error message. This list, however, is expandable
			 * as desired. Just add a new case with the pattern above, create a new
			 * Address and PhoneNumber class (must extend the abstract classes) and 
			 * add the information specific for the new country.
			 */
				
			default:
				throw new InvalidCountryCodeException();
		}
	}
}