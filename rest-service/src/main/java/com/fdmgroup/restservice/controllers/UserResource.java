package com.fdmgroup.restservice.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.fdmgroup.restservice.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	@Autowired
	UserRepository repository;

	public UserResource(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping(path="/users")
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public EntityModel<User> getUser(@PathVariable final long id) throws UserNotFoundException {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("Invalid user id");
		}
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User newUser) {
		User savedUser = repository.save(newUser);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable final long id) throws UserNotFoundException {
		repository.deleteById(id);
	}
}
