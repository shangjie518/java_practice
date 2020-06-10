package com.shang.ioc.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstTest {

	@Test
	public void test() {
		String xmlPath="applicationcontext.xml";
		ApplicationContext ac= new ClassPathXmlApplicationContext(xmlPath);
		System.out.println(ac.getBean("people"));
		
		System.out.println(ac.getBean("people-static"));
		
		System.out.println(ac.getBean("people-bean"));
		System.out.println("-------------------------");
		System.out.println(ac.getBean("people"));
		System.out.println(ac.getBean("people"));
		System.out.println(ac.getBean("people"));
	}
}
