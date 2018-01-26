package com.kriskringle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kriskringle.domain.Member;
import com.kriskringle.service.KrisKringleService;

@RestController
public class MemberController extends AbstractBaseController {

	@Autowired
	KrisKringleService service;

	@RequestMapping(path = "member/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Member> createParty(@PathVariable("id") Long id) {
		return new ResponseEntity<Member>(service.getMember(id), HttpStatus.OK);
	}

}
