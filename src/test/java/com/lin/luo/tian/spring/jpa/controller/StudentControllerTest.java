package com.lin.luo.tian.spring.jpa.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.luo.tian.spring.jpa.domain.Student;
import com.querydsl.core.types.Predicate;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations={"classpath:application-test.properties"})
@SpringBootTest
public class StudentControllerTest {
	@Autowired
	private StudentController studentController;
	
	@Test
	public void test() {
		List<Student> students = studentController.getAllStudents();
		if(null != students) {
			students.forEach(student->{
				System.out.println(student.toString());
			});
		}
	}
	
	@Test
	public void testGetStudentById() {
		Student student = studentController.getStudentById(1L);
		System.out.println(student);
	}
	
	@Test
	public void testGetStudentWithName() {
		Student student = studentController.getStudentWithName("zhangsan");
		System.out.println(student);
	}
	
	@Test
	public void testGetStudentWithNameAndTelephone() {
		
	}

}
