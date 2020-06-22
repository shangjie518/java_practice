package com.shang.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {

	public static GoodsDao getBean() {
		GoodsDao good= new GoodsDao();
		Aspect aop= new Aspect();
		Enhancer enhance= new Enhancer();
		enhance.setSuperclass(GoodsDao.class);
		enhance.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				aop.before();
				Object obj= arg1.invoke(good, arg2);
				aop.after();
				return obj;
			}});
		
		return (GoodsDao)enhance.create();
	}
}
