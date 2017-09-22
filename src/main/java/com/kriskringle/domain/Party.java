package com.kriskringle.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity 
public class Party {

	@Id
	@Column(name="party_code")
	private String partyCode;
	
	@OneToMany(mappedBy="id")
	private Set<Member> members;
	
	private LocalDate dateOfDraw;
	
}