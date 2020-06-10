package com.shang.ioc.static_factory;

import com.shang.ioc.common.People;

public class BeanFactory {

	BeanFactory(){
		System.out.println("Default constructor: BeanFactory()....");
	}
	public static People createPeople() {
		return new People();
	}
}
