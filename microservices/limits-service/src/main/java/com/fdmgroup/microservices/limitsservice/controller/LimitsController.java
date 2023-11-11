package com.fdmgroup.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.microservices.limitsservice.configuration.LimitsConfiguration;
import com.fdmgroup.microservices.limitsservice.dao.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	LimitsConfiguration limitsConfiguration;
	
	@GetMapping(path = "/limits")
	public Limits getLimits() {
		return new Limits(limitsConfiguration.getMinimum(), limitsConfiguration.getMaximum());
	}

}
