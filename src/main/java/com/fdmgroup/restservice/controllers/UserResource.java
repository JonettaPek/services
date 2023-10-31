package com.fdmgroup.restservice.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.restservice.dao.User;
import com.fdmgroup.restservice.exceptions.UserNotFoundException;
import com.fdmgroup.restservice.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserService userService;
	
	public UserResource(final UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping(path="/static-users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(path="/static-users/{id}")
	public EntityModel<User> getUser(@PathVariable final int id) throws UserNotFoundException {
		EntityModel<User> entityModel = EntityModel.of(userService.find(id));
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@PostMapping(path="/static-users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User newUser) {
		User savedUser = userService.save(newUser);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/static-users/{id}")
	public void deleteUser(@PathVariable final int id) throws UserNotFoundException {
		userService.delete(id);
	}
}
