package com.fdmgroup.springdatajpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fdmgroup.springdatajpa.dao.Course;

@Repository
public class CourseSpringJdbcRepository {
	
	@Autowired
	private JdbcTemplate template;
	
	private final static String INSERT_QUERY =
			"""
				INSERT INTO course (id, name, author)
				VALUES (?, ?, ?);
			""";
	
	private final static String DELETE_QUERY =
			"""
				DELETE FROM course
				WHERE id = ?;	
			""";
	
	private final static String SELECT_QUERY =
			"""
				SELECT * FROM course
				WHERE id = ?;	
			""";
	
	public void insert(Course course) {
		template.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void delete(long id) {
		template.update(DELETE_QUERY, id);
	}
	
	public Course find(long id) {
		return template.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
