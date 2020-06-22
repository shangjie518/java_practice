package com.shang.cglib;

import org.junit.Test;

public class runTest {

	@Test
	public void Test() {
		GoodsDao proxy=MyBeanFactory.getBean();
		proxy.add();
		proxy.delete();
		proxy.update();
		proxy.find();
	}
}
