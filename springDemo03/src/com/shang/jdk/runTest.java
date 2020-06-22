package com.shang.jdk;

import org.junit.Test;

public class runTest {
	@Test
	public void test() {
		CustomerDao dao=BeanFactory.getBean();
		dao.add();
		dao.delete();
		dao.update();
		dao.find();
	}

}
