package com.kriskringle.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.kriskringle.exception.InvalidDateException;

public class DateUtils {
	private static final String DATE_PATTERN = "dd-MM-yyyy";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	public static LocalDate getDateFormatted(String date) throws InvalidDateException {
		try {
		return LocalDate.parse(date, DATE_FORMATTER);
		} catch(DateTimeParseException e) {
			throw new InvalidDateException();
		}
	}
	
	public static String format(LocalDate date) {
		return date.format(DATE_FORMATTER);
	}
	
	public static String getDateFormat() {
		return DATE_PATTERN;
	}
}
