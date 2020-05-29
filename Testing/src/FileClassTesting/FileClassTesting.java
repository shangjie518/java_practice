package FileClassTesting;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class FileClassTesting {
	public static void main(String [] args) {
		System.out.println("pathSeparator:" + File.pathSeparator);
		System.out.println("pathSeparatorChar:" + File.pathSeparatorChar);
		System.out.println("separatorChar:" + File.separatorChar);
		System.out.println("separator:" + File.separator);
		
		System.getProperties().list(System.out);
		String str = "hello world !!!";
		InputStream in = new ByteArrayInputStream(str.getBytes());

		
		File [] files= File.listRoots();
		for (int i=0;i< files.length; i++)
			System.out.println(files[i]);
	}
	
	
	
}
