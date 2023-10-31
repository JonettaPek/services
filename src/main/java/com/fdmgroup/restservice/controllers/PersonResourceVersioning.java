package com.fdmgroup.restservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.restservice.dao.Name;
import com.fdmgroup.restservice.dao.PersonV1;
import com.fdmgroup.restservice.dao.PersonV2;


@RestController
public class PersonResourceVersioning {
	
	@GetMapping(path="/v1/person")
	public PersonV1 getPersonV1URI() {
		return new PersonV1("John Doe");
	}
	
	@GetMapping(path="/v2/person")
	public PersonV2 getPersonV2URI() {
		return new PersonV2(new Name("John", "Doe"));
	}

	@GetMapping(path="/person", params="version=1")
	public PersonV1 getPersonV1Param() {
		return new PersonV1("John Doe");
	}
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getPersonV2Param() {
		return new PersonV2(new Name("John", "Doe"));
	}
	
	@GetMapping(path="/person", headers="X-API-VERSION=1")
	public PersonV1 getPersonV1Header() {
		return new PersonV1("John Doe");
	}
	
	@GetMapping(path="/person", headers="X-API-VERSION=2")
	public PersonV2 getPersonV2Header() {
		return new PersonV2(new Name("John", "Doe"));
	}
	
	@GetMapping(path="/person", produces="application/vnd.company.app-v1+json")
	public PersonV1 getPersonV1AcceptHeader() {
		return new PersonV1("John Doe");
	}
	
	@GetMapping(path="/person", produces="application/vnd.company.app-v2+json")
	public PersonV2 getPersonV2AcceptHeader() {
		return new PersonV2(new Name("John", "Doe"));
	}
}
