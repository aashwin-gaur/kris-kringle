package com.kriskringle.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kriskringle.domain.Member;
import com.kriskringle.domain.Party;
import com.kriskringle.exception.InvalidDateException;
import com.kriskringle.helper.PartyResponse;
import com.kriskringle.repository.MemberRepository;
import com.kriskringle.repository.PartyRepository;
import com.kriskringle.util.PartyUtils;

@Service
public class KrisKringleService {

	
	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	
	@Transactional
	public PartyResponse.Wrapper getParty(String id){
		Party party = partyRepository.getOne(id);
		return PartyResponse.wrap(party);
	}
	
	public PartyResponse.Wrapper createParty(LocalDate date) throws InvalidDateException{
		if (date.compareTo(LocalDate.now()) < 1) {
			throw new InvalidDateException();
		}
		Party party = PartyUtils.createParty(date);
		partyRepository.save(party);
		return PartyResponse.wrap(party);
	}
	
	@Transactional
	public Member getMember(Long id) {
		return memberRepository.findOne(id);
	}
	
	public List<PartyResponse.Wrapper> getAllParties(){
		List<PartyResponse.Wrapper> allParties = new ArrayList();
		partyRepository.findAll().forEach(party->{
			allParties.add(PartyResponse.wrap(party));
		});
		return allParties;
	}
	
	
}
