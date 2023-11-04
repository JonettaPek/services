package com.fdmgroup.springdatajpa.repository;

import org.springframework.stereotype.Repository;

import com.fdmgroup.springdatajpa.dao.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public void delete(long id) {
		Course course = this.find(id);
		entityManager.remove(course);
	}
	
	public Course find(long id) {
		return entityManager.find(Course.class, id);
	}
}
