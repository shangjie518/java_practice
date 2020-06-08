package com.shang.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstTest {
	@Test
	public void test() {
		String xmlPath="applicationcontext.xml";
		ApplicationContext ac= new ClassPathXmlApplicationContext(xmlPath);
		PersonDao personDaoImpl=(PersonDao)ac.getBean("personDao");
		personDaoImpl.add();
	}
}
