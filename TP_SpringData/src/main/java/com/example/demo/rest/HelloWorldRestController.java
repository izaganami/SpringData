package com.example.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloWorldRestController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {
		return "welcome";
	}
  
	@RequestMapping(value = "/HiJason", method = RequestMethod.GET)
	public InnerPerson sayHelloAgain() {
		return new InnerPerson("Amina","BARMANI");
	}
	
	
	private class InnerPerson{
		private String firstName;
		private String lastName;
		
		
		public InnerPerson(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
			
	}

}