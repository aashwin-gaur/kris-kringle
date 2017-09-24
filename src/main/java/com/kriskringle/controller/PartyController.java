package com.kriskringle.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kriskringle.exception.InvalidDateException;
import com.kriskringle.helper.PartyResponse;
import com.kriskringle.service.KrisKringleService;
import com.kriskringle.util.DateUtils;

@RestController
public class PartyController extends AbstractBaseController {

	@Autowired
	KrisKringleService service;

	@RequestMapping(path = "party/create/{date}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<PartyResponse.Wrapper> createParty(@PathVariable("date") String date)
			throws InvalidDateException {
		LocalDate dateObj = DateUtils.getDateFormatted(date);
		return new ResponseEntity<PartyResponse.Wrapper>(service.createParty(dateObj), HttpStatus.OK);
	}

	@RequestMapping(path = "party/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<PartyResponse.Wrapper> getParty(@PathVariable("id") String id) {
		return new ResponseEntity<PartyResponse.Wrapper>(service.getParty(id), HttpStatus.OK);
	}

	@RequestMapping(path = "party/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<PartyResponse.Wrapper>> getParty() {
		return new ResponseEntity<>(service.getAllParties(),HttpStatus.OK);
	}
	
}
