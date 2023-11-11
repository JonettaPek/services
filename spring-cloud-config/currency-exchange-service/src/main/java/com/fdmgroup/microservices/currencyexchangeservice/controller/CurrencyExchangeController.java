package com.fdmgroup.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.microservices.currencyexchangeservice.dao.CurrencyExchange;

@RestController
@RequestMapping(path = "/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@GetMapping(path = "/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchange getExchangeRate(@PathVariable final String fromCurrency,
			@PathVariable final String toCurrency) {
		CurrencyExchange currencyExchange = new CurrencyExchange(1_000L, fromCurrency, toCurrency, BigDecimal.valueOf(50));
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
