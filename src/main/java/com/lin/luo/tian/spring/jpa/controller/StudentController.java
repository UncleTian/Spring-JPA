package com.lin.luo.tian.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lin.luo.tian.spring.jpa.domain.Student;
import com.lin.luo.tian.spring.jpa.repositry.StudentPredicteRepositry;
import com.lin.luo.tian.spring.jpa.repositry.StudentRepositry;
import com.querydsl.core.types.Predicate;

@Controller
@RequestMapping("/dcl")
public class StudentController {
	@Autowired
	private StudentRepositry studentRepositry;
//	@Autowired
//	private StudentPredicteRepositry predicteRepositry;

	public List<Student> getAllStudents() {
		return studentRepositry.findAll();
	}

	public Student getStudentById(Long id) {
		return studentRepositry.findOne(id);
	}

	public Student getStudentWithName(String name) {
		return studentRepositry.getStudentWithName(name);
	}

//	public Student getStudentWithNameAndTelephone(Predicate predicate) {
//		return predicteRepositry.findOne(predicate);
//	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public HttpEntity<PagedResources<Student>> students(Pageable pageable, PagedResourcesAssembler assembler) {
		Page<Student> students = studentRepositry.findAll(pageable);
		return new ResponseEntity<>(assembler.toResource(students), HttpStatus.OK);
	}
}
