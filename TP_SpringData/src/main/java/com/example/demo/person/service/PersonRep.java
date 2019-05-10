package com.example.demo.person.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
/* create,read,update and delete interface to avoid boiler plate code usually written in jpa without the spring data layer*/
public interface PersonRep extends CrudRepository<Person, Integer> {
	// recherche une personne par son attribut "Name"
	List<Person> findByfirstName(String nom);

}
