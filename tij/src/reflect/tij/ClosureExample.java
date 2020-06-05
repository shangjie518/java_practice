package reflect.tij;

import reflect.tij.Road.Roadtest;

interface test1{
	void identify();
}

interface test2{
	void identify();
}


interface Walk{
	void walk();
}
class Road{
	public void walk() {
		System.out.println("Road::Walking");
	}
	
	static class Roadtest{
		public Roadtest() {
			System.out.println("Road::Roadtest");
		}
		
	}
}
class Pedestrian extends Road{
	public Pedestrian() {}
	public void walk() {
		System.out.println("Pedestrian::Walking");
	}
	
	public Walk getcallbackReference() {
		return new Closure();
	}
	
	private class Closure implements Walk{

		@Override
		public void walk() {
			System.out.println("Closure::Walking");
			
		}
		
	}
}
public class ClosureExample {

	public static void main(String[] args) {
		Pedestrian r=new Pedestrian();
		r.walk();
		r.getcallbackReference().walk();
		
		Roadtest rt= new Roadtest();
		Road test1 =new Road();
		Road test2 =new Road();
		
	}
	
}
