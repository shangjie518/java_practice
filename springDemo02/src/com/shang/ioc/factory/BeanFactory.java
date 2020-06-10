package com.shang.ioc.factory;

import com.shang.ioc.common.People;

public class BeanFactory {

	public People createPeople() {
		return new People();
	}
}
