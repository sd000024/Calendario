package es.uja.calendario.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

import org.springframework.format.Formatter;
/** Sample Spring Formatter Implementation to process LocalDate from Form POST*/
public class LocalDateFormatter implements Formatter<LocalDate> {

	@Override
	public String print(LocalDate object, Locale locale) {
		 if (object == null)
	            return null;
	        return object.toString();
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		if (text == null)
            return null;
		
        return LocalDate.parse(text);	}

}