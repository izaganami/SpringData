package com.example.demo.person.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRep extends CrudRepository<Person, Integer> {
	// recherche une personne par son attribut "Name"
	List<Person> findByfirstName(String nom);

}
