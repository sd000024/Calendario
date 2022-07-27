package es.uja.calendario.utils;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.format.Formatter;
/** Sample Spring Formatter Implementation to process LocalDate from Form POST*/
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

	@Override
	public String print(LocalDateTime object, Locale locale) {
		 if (object == null)
	            return null;
	        return object.toString();
	}

	@Override
	public LocalDateTime parse(String text, Locale locale) throws ParseException {
		if (text == null)
            return null;
		
        return LocalDateTime.parse(text);	}

}