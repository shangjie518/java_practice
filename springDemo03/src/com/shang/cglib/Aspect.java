package com.shang.cglib;

public class Aspect {
	
	public void before() {
		System.out.println("aop: before");
	}
	
	public void after() {
		System.out.println("aop: after");
	}

}

