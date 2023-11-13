package com.fdmgroup.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fdmgroup.microservices.currencyconversionservice.dao.CurrencyConversion;

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
//remove port configuration 
//feign client talks to eureka and picks up an available instance of currency exchange service
//client-side load balancing
@FeignClient(name = "currency-exchange") 
public interface CurrencyExchangeProxy {

	@GetMapping(path = "/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversion getExchangeRate(@PathVariable final String fromCurrency,
			@PathVariable final String toCurrency);
}
