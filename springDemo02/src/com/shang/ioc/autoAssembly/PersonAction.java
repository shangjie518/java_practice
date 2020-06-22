package com.shang.ioc.autoAssembly;


public class PersonAction {


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
