package com.ssreddy.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssreddy.hibernate.dao.PersonDAO;
import com.ssreddy.hibernate.model.Person;

@RestController
@RequestMapping(value="/spring-orm")
public class PersonController {

	@Autowired
	private PersonDAO dao;
	
	
	@PostMapping(value="/savePerson")
	public String save(@RequestBody Person person) {
		dao.savePerson(person);
		return "Success";
	}
	
	@GetMapping(value="/getAll")
	public List<Person> getAllPerson(){
		return dao.getPersion();
	}
	
}
