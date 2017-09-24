package com.kriskringle.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

public abstract class KrisKringleException extends Exception {

	private static final long serialVersionUID = -4962667958881901908L;

	
	public abstract ExceptionResponseObject getResponse();

	@Data
	@AllArgsConstructor
	protected static final class ExceptionResponseObject {
		@JsonProperty("Error message")
		private final String message;
	}

}
