package com.kriskringle.helper;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kriskringle.domain.Party;

import lombok.Data;

@Data
public final class PartyResponse {

	private String partyCode;
	private LocalDate dateOfDraw;
	private Set<String> members;
	
	public static Wrapper wrap(Party party) {
		return new Wrapper(party);
	}

	public static class Wrapper {

		@JsonProperty("partyResponse")
		private final PartyResponse response;

		private Wrapper(Party party) {
			response = new PartyResponse();
			response.setDateOfDraw(party.getDateOfDraw());
			response.setPartyCode(party.getPartyCode());
			response.setMembers(party.getMembers().stream().map(t->t.getName()).collect(Collectors.toSet()));
		}
	}
}
