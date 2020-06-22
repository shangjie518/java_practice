package com.shang.ioc.autoAssembly;



public class PersonServiceImpl implements PersonService {


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
