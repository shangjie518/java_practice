package proxy.tij;

public class RealObject implements Interface {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("RealObject do something");

	}

	@Override
	public void somethingElse(String str) {
		// TODO Auto-generated method stub
		System.out.println("RealObjec something Else "+str);
	}

}
