package com.shang.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

	public static CustomerDao getBean() {

		CustomerDaoImpl cus = new CustomerDaoImpl();

		CustomerDao proxy = (CustomerDao) Proxy.newProxyInstance(BeanFactory.class.getClassLoader(),
				new Class[] { CustomerDao.class }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
				
						
						return  method.invoke(cus, args);
					}

				});

		return proxy;
	}

}
