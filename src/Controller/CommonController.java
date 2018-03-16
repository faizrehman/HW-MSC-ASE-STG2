package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import exception.InvalidDataException;

public class CommonController {

	private Date parseDate(String date) throws ParseException, InvalidDataException {
		if(date == null || date.isEmpty())
			throw new InvalidDataException("Invalid Date format.");
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD-HH:MM");
		return formatter.parse(date);
		
	}
	
	
}
