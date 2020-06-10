package com.shang.ioc.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Resource(name="personDao")
	private PersonDao personDao;
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		personDao.add();
		System.out.println("PersonServiceImpl:add()...");
	}

}
