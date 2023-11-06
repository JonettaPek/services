package com.fdmgroup.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.restservice.dao.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
