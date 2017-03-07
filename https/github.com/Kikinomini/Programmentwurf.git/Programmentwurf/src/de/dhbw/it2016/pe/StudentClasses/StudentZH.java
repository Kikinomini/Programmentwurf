package de.dhbw.it2016.pe.StudentClasses;

import java.util.List;

import de.dhbw.it2016.pe.AbstractStudentFactory;
import de.dhbw.it2016.pe.AddressClasses.AddressInterface;
import de.dhbw.it2016.pe.AddressClasses.AddressZH;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberInterface;
import de.dhbw.it2016.pe.PhoneNumberClasses.PhoneNumberZH;

public class StudentZH extends Student implements AbstractStudentFactory {

	protected AddressZH address;
	protected PhoneNumberZH phone;
	
	public StudentZH(List<String> data) {
		firstName = data.get(1);
		lastName = data.get(2);
		address = createAddress(data);
		phone = createPhoneNumber(data);
		id = data.get(0);
	}

	public String address() {
		return address.formatAddress();
	}

	public String phone() {
		return phone.formatNational();
	}
	
	public String intlPhone() {
		return phone.formatInternational();
	}

	@Override
	public AddressZH createAddress(List<String> data) {
		return new AddressZH(data.get(3), data.get(4), data.get(5),
				data.get(6), data.get(10));
	}

	@Override
	public PhoneNumberZH createPhoneNumber(List<String> data) {
		return new PhoneNumberZH(data.get(8), data.get(9));
	}
	
	@Override
	public String getCompleteName() 
	{
		/* In the People's Republic of China, the surname precedes the first name(s)
		 *  Hence, this method has to be overwritten*/
		
		return id + ": " + super.lastName + " " + super.firstName;
	}
}