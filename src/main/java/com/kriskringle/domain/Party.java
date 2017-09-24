package com.kriskringle.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity 
public class Party {

	@Id
	private String partyCode;
	@OneToMany(mappedBy="party", fetch= FetchType.EAGER)
	private Set<Member> members;
	private LocalDate dateOfDraw;
	
	public Party(LocalDate dateOfDraw) {
		this.dateOfDraw = dateOfDraw;
	}
	
}