package com.ssreddy.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssreddy.hibernate.model.Person;

@Repository
@Transactional
public class PersonDAO {

	@Autowired
	private SessionFactory factory;
	
	public void savePerson(Person person) {
		getsession().save(person);	
	}
	
	private Session getsession() {
		Session session= factory.getCurrentSession();
		if(session == null) {
			session=factory	.openSession();
		}
		return session;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Person> getPersion(){
		return getsession().createCriteria(Person.class).list();
	}
	
}
