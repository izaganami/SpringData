package com.example.demo.person.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class PersonEntityManager {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void addAPerson(String name, String lastName, Integer age) {

		em.persist(new Person(name,lastName, age));
	}
	public List searchAllPerson(){
		Query query = em.createQuery("Select P from Person P");
		return query.getResultList();
	}
	public List searchAllPersonWithAge(){
		Query query = em.createQuery("Select P from Person P Where age <30");
		return query.getResultList();
	}

}
