package com.lin.luo.tian.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lin.luo.tian.spring.jpa.domain.Student;
import com.lin.luo.tian.spring.jpa.repositry.StudentPredicteRepositry;
import com.lin.luo.tian.spring.jpa.repositry.StudentRepositry;
import com.querydsl.core.types.Predicate;

@Controller
public class StudentController {
	@Autowired
	private StudentRepositry studentRepositry;
	@Autowired
	private StudentPredicteRepositry predicteRepositry;
		
	public List<Student> getAllStudents() {
		return studentRepositry.findAll();
	}
	
	public Student getStudentById(Long id) {
		return studentRepositry.findOne(id);
	}
	
	public Student getStudentWithName(String name) {
		return studentRepositry.getStudentWithName(name);
	}
	
	public Student getStudentWithNameAndTelephone(Predicate predicate) {
		return predicteRepositry.findOne(predicate);
	}
}
