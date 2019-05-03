package com.example.demo.person.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

@Repository
public class PersonEntityManagerFromFactory {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public void addAPersonVerbose(String name, String lastName, Integer age) throws Exception {
		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(new Person("verbose em Amina", "verbose em Barmani", 21));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
	}

}
