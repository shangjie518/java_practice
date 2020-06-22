package proxy.tij;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


class MobileCus implements Customer{

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Mobile Customer Add()");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Mobile Customer update()");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Mobile Customer delete()");
	}
	
}
class Asepct{
	static void before() {
		System.out.println();
	}
}


public class SimpleProxyDemo3 {
	
	public static void main(String[] args) {
		
		MobileCus mobile=new MobileCus();
		
		Customer cus =(Customer)Proxy.newProxyInstance(SimpleProxyDemo3.class.getClassLoader(), new Class[] {Customer.class}, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				switch(method.getName()) {
					case "add":
						return method.invoke(mobile, args);
					case "delete":
						return method.invoke(mobile, args);
					case "update":
						return method.invoke(mobile, args);
					default:
						System.out.println("default");
						break;
				}
				
				return null;
			}
			
		});
		
		cus.add();
		cus.delete();
		cus.update();
	}

}
