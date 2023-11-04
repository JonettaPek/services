package com.fdmgroup.springdatajpa.runner;
//package com.fdmgroup.learnjpaandhibernate.runner;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.fdmgroup.learnjpaandhibernate.dao.Course;
//import com.fdmgroup.learnjpaandhibernate.repository.CourseJpaRepository;
//
//@Component
//public class CourseJpaRunner implements CommandLineRunner {
//
//	@Autowired
//	private CourseJpaRepository repository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		 repository.insert(new Course(1, "Learn AWS", "in28minutes"));
//		 repository.insert(new Course(2, "Learn SQL", "in28minutes"));
//		 repository.delete(1);
//		 System.out.println(repository.find(2));
//		 
//	}
//
//}
