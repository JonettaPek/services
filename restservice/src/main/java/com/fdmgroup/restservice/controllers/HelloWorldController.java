package com.fdmgroup.restservice.controllers;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.restservice.dao.User;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping(path="/greet")
	public String greet() {
		return "Hello World!";
	}
	
	@GetMapping(path="/greet-i18n")
	public String i18nGreet() {
		Locale locale = LocaleContextHolder.getLocale();
		return this.messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
	
	@GetMapping(path="/greet/{name}")
	public String greetName(@PathVariable String name) {
		return String.format("Hello, %s", name);
	}
	
	@GetMapping(path="/jonetta")
	public User user() {
		return new User(1, "Jonetta", LocalDate.now().minusYears(23));
	}
	
	@GetMapping(path="/{name}/{age}")
	public User createUser(@PathVariable String name, @PathVariable long age) {
		return new User(1, name, LocalDate.now().minusYears(age));
	}
}
