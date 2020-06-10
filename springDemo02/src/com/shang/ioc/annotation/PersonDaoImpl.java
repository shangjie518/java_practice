package com.shang.ioc.annotation;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("PersonDaoImpl:add()....");

	}

}
