package com.kriskringle.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kriskringle.domain.Party;
import com.kriskringle.exception.InvalidDateException;
import com.kriskringle.helper.PartyCreateResponse;
import com.kriskringle.repository.PartyRepository;
import com.kriskringle.util.DateUtils;
import com.kriskringle.util.PartyUtils;

@RestController
public class PartyController extends AbstractBaseController{
	
	@Autowired
	PartyRepository partyRepository;
	
	@RequestMapping(path="party/create/{date}" , method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<PartyCreateResponse.Wrapper> createParty(@PathVariable("date") String date) throws InvalidDateException{
		LocalDate dateObj = DateUtils.getDateFormatted(date);
		if(dateObj.compareTo(LocalDate.now())<1) {
			//TODO: proper error handling
			throw new InvalidDateException();
		}
		Party party = PartyUtils.createParty(dateObj);
		partyRepository.save(party);
		return new ResponseEntity<PartyCreateResponse.Wrapper>(PartyCreateResponse.wrap(party),HttpStatus.OK);
	}	
}
