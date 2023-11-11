package com.fdmgroup.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.microservices.currencyexchangeservice.dao.CurrencyExchange;
import com.fdmgroup.microservices.currencyexchangeservice.exception.CurrencyExchangeNotFoundException;
import com.fdmgroup.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
@RequestMapping(path = "/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping(path = "/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchange getExchangeRate(@PathVariable final String fromCurrency,
			@PathVariable final String toCurrency) throws CurrencyExchangeNotFoundException {
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(fromCurrency.toUpperCase(), toCurrency.toUpperCase());
		if (currencyExchange == null) {
			throw new CurrencyExchangeNotFoundException("Invalid currency pairs");
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
