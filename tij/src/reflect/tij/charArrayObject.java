package reflect.tij;

public class charArrayObject {
	public static void main(String[] args) {
		char[] c= new char[2];
		if(c.getClass().isPrimitive()) {
			System.out.println("primitive");
		}else {
			System.out.println("No primitive, an array of char is Object");
		}
	}

}
