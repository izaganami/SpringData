package com.example.demo.person.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonSpringData {

	@Autowired
	private PersonRep person;
	
	public List<Person> getPerson(String name){
		return person.findByfirstName(name);
	}
 
}
