package com.shang.ioc;

public class PersonServiceImpl implements PersonService {
	
	private PersonDao p1;
	



	public void setTest(PersonDao personDao) {
		this.p1 = personDao;
	}



	@Override
	public void addPerson() {
		// TODO Auto-generated method stub
		p1.add();
		System.out.println("PersonServiceImpl:addPerson()");
	}


	

}
