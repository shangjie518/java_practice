package reflect.tij;
import gui.tij.Utilities;
import java.util.Scanner;

class Gum {
	static {
		System.out.println("loading Gum");
	}

	public Gum() {
		System.out.println("Gum constructor loading");

	}
}

class Candy {
	static {
		System.out.println("loading Candy");
	}
	public Candy() {
		System.out.println("Candy constructor loading");

	}
}

class Cookie {
	static {
		System.out.println("loading Cookie");
	}
}

public class SweetShop {

	void output() {
		System.out.println("Inside Main ");
		new Candy();
		System.out.println("after creating Candy");
		try {
			Class<?> c = Class.forName("reflect.tij.Gum");
			c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't find Gum class");
		}
		System.out.println("after Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("after creating Cookie");
	
	}
	

	public static void main(String[] args) {
		if(args.length==1) {
			if(args[0].equalsIgnoreCase("Candy") ){
				try {
				Class<?> c = Class.forName("reflect.tij.Candy");
				Utilities.printClassInfo(c);
				//c.newInstance();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
