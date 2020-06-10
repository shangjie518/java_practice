package com.shang.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FirstTest {
	@Test
	public void test() {
		String xmlPath="C:\\Users\\shangji\\eclipse-workspace\\springDemo01\\src\\com\\shang\\ioc\\applicationcontext.xml";
		ApplicationContext ac= new FileSystemXmlApplicationContext(xmlPath);
		PersonService ps=(PersonService)ac.getBean("personService");
		ps.addPerson();
	}
}
