package reflectDemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;



class FileClassLoader extends ClassLoader{
	
	final static String loadpath = "c:"+File.separator + "Mywork" +File.separator + "Java" + File.separator;

	public Class <?> findClass(String className) {
		byte[] b = null;
		String cp [] = className.split("\\.");
		for (int x=0; x<cp.length;x++)
			System.out.println(cp[x]);
		try {
			b = loadClassData(cp[cp.length-1]+".class");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.defineClass(className, b, 0, b.length);
	}
	
	private byte[] loadClassData(String classname) throws Exception {
		File file = new File(loadpath + classname);
		FileInputStream fin = new FileInputStream (file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] data = new byte[20];
		int temp=0;
		while ((temp = fin.read(data) )!= -1)
		{
			bos.write(data, 0, temp);
		}
		fin.close();
		bos.close();
		return bos.toByteArray();
		
	}
	
}


public class testDemo {
	public static void main(String[] args) throws Exception {
//		Class<?> cls = member.class;
//		System.out.println(cls.getClassLoader());
//		System.out.println(cls.getClassLoader().getParent());
//		System.out.println(cls.getClassLoader().getParent().getParent());
		
		FileClassLoader fcl= new FileClassLoader();
		Class <?> cls = fcl.findClass("reflectDemo.Person");
		Object obj = cls.newInstance();
		Method mtd = cls.getDeclaredMethod("info");
		mtd.invoke(obj);
		
		
//		Method method = fcl.findClass("Person.class").forName("reflectDemo.Person").getDeclaredMethod(info, void);
		
		
	}

}
