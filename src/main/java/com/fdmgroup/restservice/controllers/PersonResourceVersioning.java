package com.fdmgroup.restservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.restservice.dao.Name;
import com.fdmgroup.restservice.dao.PersonV1;
import com.fdmgroup.restservice.dao.PersonV2;

@RestController
public class PersonResourceVersioning {
	
	@GetMapping(path="/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("John Doe");
	}
	
	@GetMapping(path="/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("John", "Doe"));
	}

}
