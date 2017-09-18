package com.kriskringle.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Party {

	@Id
	@Column(name="party_code")
	private String partyCode;
	
	private Set<Member> members;
	
	private LocalDate dateOfDraw;
}
