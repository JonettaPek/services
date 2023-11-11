package com.fdmgroup.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.microservices.currencyexchangeservice.dao.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	public CurrencyExchange findByFromAndTo(String from, String to);

}
