package com.shang.ioc.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class runTest {

	@Test
	public void test() {
		String path="annotationXml.xml";
		ApplicationContext ac= new ClassPathXmlApplicationContext(path);
		PersonAction pa=(PersonAction)ac.getBean("personAction");
		pa.add();
	}
}
