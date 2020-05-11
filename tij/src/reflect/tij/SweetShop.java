package reflect.tij;

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
}

class Cookie {
	static {
		System.out.println("loading Cookie");
	}
}

public class SweetShop {

	public static void main(String[] args) {
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
}
