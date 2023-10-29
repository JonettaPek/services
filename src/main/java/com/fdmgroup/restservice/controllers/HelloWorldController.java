package com.fdmgroup.restservice.controllers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.restservice.dao.User;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

	@GetMapping(path="/greet")
	public String greet() {
		return "Hello World!";
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
