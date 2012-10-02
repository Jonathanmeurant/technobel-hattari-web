package hattari.web.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validation {
	
	public boolean textValidation (String text) {
		
		boolean matchFound = Pattern.matches("\\w+", text);
		
		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean emailValidation (String text) {
		
		try {
			InternetAddress email = new InternetAddress(text);
			email.validate();
		} catch (AddressException ae) {
			return false;
		}
		
		return true;
		
	}
	
	public boolean integerValidation (String textInteger) {
		
		Pattern p = Pattern.compile("\\d+");
		
		Matcher m = p.matcher(textInteger);	
		
		boolean matchFound = m.matches();
		
		if (matchFound) {
			return true;
		} else {
			return false;
		}
	}
	
}
