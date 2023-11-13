package com.fdmgroup.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping(path = "/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "fallbackMethod") // name = "default" attempts thrice
//	@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
//	@RateLimiter(name = "default") // allows 10_000 calls to sample api every 10 secs
	@Bulkhead(name = "default")
	public String sampleApi() {
		logger.info("called sample api");
//		ResponseEntity<String> entity = 
//				new RestTemplate()
//					.getForEntity("http://localhost:8080/dummy-uri", String.class);
//		return entity.getBody();
		return "sample-api";
	}
	
	private String fallbackMethod(Exception exception) {
		return "fallback-method";
	}
}
