package com.shang.ioc.assembly;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class runTest {
	@Test
	public void test() {
		String xmlPath="applicationcontext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		System.out.println(ac.getBean("people1"));
		System.out.println(ac.getBean("people2"));

	}

}
