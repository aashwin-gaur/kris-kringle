package com.kriskringle.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder @AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "party",referencedColumnName="partyCode")
	private Party party;
	
	@OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Role> roles;
	
}
