package com.kriskringle.helper;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kriskringle.domain.Party;

import lombok.Data;

@Data
public class PartyCreateResponse {

	private String partyCode;
	private LocalDate dateOfDraw;

	public static Wrapper wrap(Party party) {
		return new Wrapper(party);
	}

	public static class Wrapper {

		@JsonProperty("partyCreateResponse")
		private final PartyCreateResponse response;

		private Wrapper(Party party) {
			response = new PartyCreateResponse();
			response.setDateOfDraw(party.getDateOfDraw());
			response.setPartyCode(party.getPartyCode());
		}

	}
}
