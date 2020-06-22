package serialization.tij;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class runTest {
	@Test
	public void test() {

		try {
			runTest.serializePeople();
			runTest.deserializePeople();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void serializePeople() throws FileNotFoundException, IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output.dat"));
		People p1 = new People("Jack", 29, "male");
		
		
		People1 p2 = new People1();
	
		p2.setName("Rose");
		p2.setAge(29);
		p2.setGender("female");
		p2.setDesc("testing descriptions");
		
		
		oos.writeObject(p1);
		oos.writeObject(p2);
		
		oos.close();
	}

	static void deserializePeople() throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream oos = new ObjectInputStream(new FileInputStream("output.dat"));

		People p1 = (People) oos.readObject();
		People1 p2 =(People1)oos.readObject();
		System.out.println(p1);
		System.out.println(p2);
		oos.close();
	}
}
