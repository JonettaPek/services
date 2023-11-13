package com.fdmgroup.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping(path = "/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "fallbackMethod") // default attempts thrice
	@CircuitBreaker(name = "sample-api", fallbackMethod = "fallbackMethod")
	public String sampleApi() {
		logger.info("called sample api");
		ResponseEntity<String> entity = 
				new RestTemplate()
					.getForEntity("http://localhost:8080/dummy-uri", String.class);
		return entity.getBody();
	}
	
	private String fallbackMethod(Exception exception) {
		return "fallback-method";
	}
}
