package proxy.tij;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleProxyDemo {
	
	public static void consumer(Interface iInterface) {
		iInterface.doSomething();
		iInterface.somethingElse("consumer");
	}

	public static void main(String[] args) {
		
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
		
		Interface obj= new RealObject();
		
		Interface obj2=(Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[] {Interface.class}, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(method.getName().equals("doSomething")) {
					System.out.println("Dynamic proxy doSomething");
					return method.invoke(obj, args);
				}
				if(method.getName().equals("somethingElse")) {
					System.out.println("Dynamic proxy somethingElse");
					return method.invoke(obj, args);
				} 
				return null;
			}
			
		});
		
		obj2.doSomething();
		obj2.somethingElse("Dynamic");
		
	}
}
