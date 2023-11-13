package com.fdmgroup.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fdmgroup.microservices.currencyconversionservice.dao.CurrencyConversion;
import com.fdmgroup.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
@RequestMapping(path = "/currency-conversion")
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping(path = "/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion calculate(
			@PathVariable final String fromCurrency,
			@PathVariable final String toCurrency,
			@PathVariable final BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("fromCurrency", fromCurrency);
		uriVariables.put("toCurrency", toCurrency);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}",
				CurrencyConversion.class,
				uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		return new CurrencyConversion(
				currencyConversion.getId(),
				fromCurrency,
				toCurrency,
				currencyConversion.getConversionMultiple(),
				quantity,
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment());
	}
	
	@GetMapping(path = "/feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion feignCalculate(
			@PathVariable final String fromCurrency,
			@PathVariable final String toCurrency,
			@PathVariable final BigDecimal quantity) {
		CurrencyConversion currencyConversion = currencyExchangeProxy.getExchangeRate(fromCurrency, toCurrency);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		currencyConversion.setEnvironment(currencyConversion.getEnvironment() + " feign");
		return currencyConversion;
		
	}
}
