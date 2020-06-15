package proxy.tij;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Agent {

	private Person actorObj= new Actor();
	public Person getProxy() {
		Person actorProxy=(Person)Proxy.newProxyInstance(Agent.class.getClassLoader(), actorObj.getClass().getInterfaces(), new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(method.getName().equals("sing")) {
					System.out.println("Agent working for sing....");
					return method.invoke(actorObj,args);
				}else if(method.getName().equals("dance")) {
					System.out.println("Agent working for dance...");
					return method.invoke(actorObj,args);
				}
				
				return null;
			}
			
		});
		
		return actorProxy;
	}
}
