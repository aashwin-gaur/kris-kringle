package com.kriskringle.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	private static final String DATE_PATTERN = "dd-MM-yyyy";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	public static LocalDate getDateFormatted(String date) {
		return LocalDate.parse(date, DATE_FORMATTER);
	}
	
	public static String format(LocalDate date) {
		return date.format(DATE_FORMATTER);
	}
	
}
