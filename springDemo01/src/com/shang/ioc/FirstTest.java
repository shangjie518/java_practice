package com.shang.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FirstTest {
	@Test
	public void test() {
		String xmlPath="applicationcontext.xml";
		ApplicationContext ac= new ClassPathXmlApplicationContext(xmlPath);
		PersonService ps=(PersonService)ac.getBean("personService");
		ps.addPerson();
	}
}
