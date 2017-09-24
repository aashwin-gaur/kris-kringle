package com.kriskringle.exception;

import java.time.LocalDate;

import com.kriskringle.util.DateUtils;

public class InvalidDateException extends KrisKringleException {

	private static final long serialVersionUID = -2667081966959183241L;
	
	@Override
	public String getMessage() {
		return "This is not a valid date! Enter a date after "+DateUtils.format(LocalDate.now()) +" and make sure the format is of the form "+DateUtils.getDateFormat();
	}

	@Override
	public ExceptionResponseObject getResponse() {
		return new ExceptionResponseObject(getMessage());
	}


}
