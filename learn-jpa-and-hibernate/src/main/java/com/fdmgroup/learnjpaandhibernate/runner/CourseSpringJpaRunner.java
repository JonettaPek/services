package com.fdmgroup.learnjpaandhibernate.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fdmgroup.learnjpaandhibernate.dao.Course;
import com.fdmgroup.learnjpaandhibernate.repository.CourseSpringJpaRepository;

@Component
public class CourseSpringJpaRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		 repository.save(new Course(1, "Learn AWS", "in28minutes"));
		 repository.save(new Course(2, "Learn SQL", "in28minutes"));
		 repository.save(new Course(3, "Learn Linux", "in28minutes"));
		 repository.deleteById(1L);
		 System.out.println(repository.findById(2L));
		 System.out.println(repository.findAll());
		 System.out.println(repository.count());
		 System.out.println(repository.findByAuthor("in28minutes"));
		 System.out.println(repository.findByAuthor(""));
		 System.out.println(repository.findByName("Learn AWS"));
		 System.out.println(repository.findByName("Learn SQL"));
	}

}
