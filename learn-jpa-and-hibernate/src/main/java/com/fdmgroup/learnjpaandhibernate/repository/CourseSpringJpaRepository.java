package com.fdmgroup.learnjpaandhibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.learnjpaandhibernate.dao.Course;

public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {

	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
