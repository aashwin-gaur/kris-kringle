package com.kriskringle.util;

import java.time.LocalDate;
import java.util.HashSet;

import com.kriskringle.domain.Party;

public class PartyUtils {

	public static Party createParty(LocalDate dateOfDraw) {
		Party party = new Party(
				RandomGenerator.generatePartyCodeUuid(),new HashSet<>(),dateOfDraw);
		return party;
	}
}
