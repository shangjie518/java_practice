package com.shang.factoryBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shang.jdk.CustomerDao;

public class runtest {

	@Test
	public void test() {
		String xmlPath="com\\shang\\factoryBean\\ApplicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		CustomerDao cd=(CustomerDao)ac.getBean("customerDaoProxy");
		cd.add();
		cd.delete();
		cd.find();
		cd.update();
	}
}
