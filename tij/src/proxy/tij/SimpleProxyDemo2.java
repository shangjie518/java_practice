package proxy.tij;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class InvokeHandler implements InvocationHandler {

	private Object proxied;

	public InvokeHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.out.println("proxied: " + proxied.getClass() + "...... method: " + method + ".....args: " + args);
		if(args!=null) {
			for (Object arg : args) {
				System.out.println("arg: " + arg);
			}
		}

		return method.invoke(proxied, args);
	}

}

public class SimpleProxyDemo2 {
	public static void main(String[] args) {
		InvokeHandler handler = new InvokeHandler(new RealObject());
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
				new Class[] { Interface.class }, handler);
		
		proxy.doSomething();
		proxy.somethingElse("Dynamic Proxy");
	}
}
