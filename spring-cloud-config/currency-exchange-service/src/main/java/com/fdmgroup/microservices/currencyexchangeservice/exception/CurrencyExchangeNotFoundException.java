package com.fdmgroup.microservices.currencyexchangeservice.exception;

public class CurrencyExchangeNotFoundException extends RuntimeException {

	public CurrencyExchangeNotFoundException(String message) {
		super(message);
	}
}
