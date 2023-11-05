package com.fdmgroup.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.restservice.dao.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
