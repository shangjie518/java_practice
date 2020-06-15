package proxy.tij;

public class SimpleProxy implements Interface {

	private Interface proxied;
	public SimpleProxy(Interface proxy) {
		this.proxied=proxy;
	}
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy doSomething");
		this.proxied.doSomething();

	}

	@Override
	public void somethingElse(String str) {
		// TODO Auto-generated method stub

		System.out.println("SimpleProxy somethingElse "+str);
		this.proxied.somethingElse(str);
	}

}
