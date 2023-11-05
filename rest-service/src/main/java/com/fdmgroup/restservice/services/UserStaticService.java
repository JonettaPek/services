package com.fdmgroup.restservice.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fdmgroup.restservice.dao.User;
import com.fdmgroup.restservice.exceptions.UserNotFoundException;

@Service
public class UserStaticService {

	private static List<User> users = new ArrayList<>();
	
	private static long userCount = 0;
	
	static {
		users.add(new User(++userCount, "Sam", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Paul", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "John", LocalDate.now().minusYears(50)));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User find(final int id) throws UserNotFoundException {
		return users
				.stream()
				.filter(u -> u.getId() == id)
				.findFirst()
				.orElseThrow(() -> new UserNotFoundException("Invalid user id"));
	}
	
	public User save(User newUser) {
		newUser.setId(++userCount);
		users.add(newUser);
		return newUser;
	}
	
	public void delete(final int id) throws UserNotFoundException {
		if (!users.removeIf(u -> u.getId() == id)) {
			throw new UserNotFoundException("Invalid user id");
		}
	}
	
}
