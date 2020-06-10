package com.shang.ioc.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller("personAction")
public class PersonAction {

	@Resource(name="personService")
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	
	public void add() {
		personService.add();
		System.out.println("PersonAction:add()...");
	}
}
