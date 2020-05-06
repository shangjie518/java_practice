package imgToBase64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class ToBase64 {
	
	final static int BUF_SIZE=1024;
	
	public String getEncode(String path) {
		File inFile= new File(path);
		String s=new String();
		try {
			FileInputStream fis= new FileInputStream(inFile);
			ByteArrayOutputStream baos= new ByteArrayOutputStream();
			byte [] buffer= new byte[BUF_SIZE];
			int readsize=0;
			while((readsize=fis.read(buffer))!=-1) {
				baos.write(buffer,0,readsize);
			}
			s= Base64.getEncoder().encodeToString(baos.toByteArray());
			System.out.println(s);
			fis.close();
			baos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
