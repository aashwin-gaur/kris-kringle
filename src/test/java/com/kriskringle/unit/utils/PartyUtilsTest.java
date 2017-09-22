package com.kriskringle.unit.utils;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;

import com.kriskringle.util.PartyUtils;

public class PartyUtilsTest {

	@Test
	public void test() {
		assertNotNull(PartyUtils.createParty(LocalDate.now()));
	}
}

