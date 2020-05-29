package BTDemo;
import javax.swing.*;

class Super{
	String name;
	public Super(String name) {
		this.name= name;
	}
	public void fun1() {
		System.out.println("this is calss super" + name);
	}
}

public class test {
	
	static int i;
	public static void main(String[] args) {
	
		System.out.println(i);
	}

}
