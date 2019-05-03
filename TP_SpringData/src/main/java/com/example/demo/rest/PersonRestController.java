package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.person.service.Person;
import com.example.demo.person.service.PersonEntityManager;
import com.example.demo.person.service.PersonEntityManagerFromFactory;
import com.example.demo.person.service.PersonJdbcTemplate;
import com.example.demo.person.service.PersonSpringData;

@RestController
@RequestMapping("/rest/person")
public class PersonRestController {

	@Autowired
	private PersonJdbcTemplate persondbcService;

	@Autowired
	private PersonEntityManagerFromFactory personEntityFromFactoryService;

	@Autowired
	private PersonEntityManager personEntityService;

	@RequestMapping(value = "/create/jdbc", method = RequestMethod.GET)
	public String oihsgfdjoisgfdjoi() {
		persondbcService.addAPerson("amina", "barmani", 21);
		return "Amina Created with jdbc template";
	}

	@RequestMapping(value = "/create/em/verbose", method = RequestMethod.GET)
	public String createPerson3() throws Exception {
		personEntityFromFactoryService
				.addAPersonVerbose("amina", "barmani", 21);
		return "Amina Created with EntityManager verbose";
	}

	@RequestMapping(value = "/create/em", method = RequestMethod.GET)
	public String createPerson2() {
		personEntityService.addAPerson("amina", "barmani", 21);
		return "Amina Created with EntityManager";
	}

	@Autowired
	private PersonSpringData personSpringData;

	@RequestMapping(value = "/search/all", method = RequestMethod.GET)
	public List searchAllPerson() {
		return personEntityService.searchAllPerson();
	}

	@RequestMapping(value = "/search/age", method = RequestMethod.GET)
	public List searchAllPersonWithAge() {
		return personEntityService.searchAllPersonWithAge();
	}

	@RequestMapping(value = "/SpringData/searchByName/{name}", method = RequestMethod.GET)
	public List<Person> searchByName(@PathVariable String name) {
		return personSpringData.getPerson(name);
	}

}