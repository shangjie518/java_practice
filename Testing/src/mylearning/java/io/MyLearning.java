package mylearning.java.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

interface AbstractFactory{
	AbstractProduct product();
}

class Factory1 implements AbstractFactory{

	@Override
	public AbstractProduct product() {
		System.out.print("Factory1 producing ");
		return new Product1();
	}
	
}

class Factory2 implements AbstractFactory{

	@Override
	public AbstractProduct product() {
		System.out.print("Factory2 producing ");
		return new Product2();
	}
	
}

interface AbstractProduct{
	void show() ;
}

class Product1 implements AbstractProduct{

	@Override
	public void show() {
		System.out.println("This is Product1");
		
	}
	
}

class Product2 implements AbstractProduct{

	@Override
	public void show() {
		System.out.println("This is Product2");
		
	}
	
}

public class MyLearning {
	final static int BUF_SIZE=8196;

	static void copyWithFileStream(File in, File out) {
		InputStream fin;
		OutputStream fout;
		byte [] buffer= new byte[BUF_SIZE];
		try {
			fin= new FileInputStream(in);
			fout= new FileOutputStream(out);
			int readsize=0;
			while((readsize=fin.read(buffer))!=-1) {
				fout.write(buffer,0,readsize);
			}
			fin.close();
			fout.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	static void copyWithBufferedStream(File in, File out) {
		InputStream bin;
		OutputStream bout;
		byte [] buffer= new byte[BUF_SIZE];
		try {
			bin= new BufferedInputStream(new FileInputStream(in));
			bout= new BufferedOutputStream(new FileOutputStream(out));
			int readsize=0;
			while((readsize=bin.read(buffer))!=-1) {
				bout.write(buffer,0,readsize);
			}
			bin.close();
			bout.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	
	public static void main(String []args){
		
		AbstractFactory af= new Factory1();
		af.product().show();
		try {
			DocumentBuilder cb= DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Path is = FileSystems.getDefault().getPath("test1","test2" );
			System.out.println(is.toString());
			System.out.println(FileSystems.getDefault().toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		File inFile= new File("C:\\Mywork\\Java\\output\\3-1Q1121K933555.png");
		try {
			FileInputStream fis= new FileInputStream(inFile);
			ByteArrayOutputStream baos= new ByteArrayOutputStream();
			byte [] buffer= new byte[BUF_SIZE];
			int readsize=0;
			while((readsize=fis.read(buffer))!=-1) {
				baos.write(buffer,0,readsize);
			}
			String s= Base64.getEncoder().encodeToString(baos.toByteArray());
			System.out.println(s);
			fis.close();
			baos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		/*String str="This is Nintendo Switch";
		InputStream in= new ByteArrayInputStream(str.getBytes());
		int c=0;
		try {while((c=in.read())!=-1) {
			System.out.print((char)c);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		String file = "C:\\Mywork\\Java\\output\\test.txt";
		try {
			FileInputStream fis= new FileInputStream(file);
			byte[] b= new byte[50];
			int off=0;
			while(fis.read(b,off,10)!=-1) {
				off+=10;
			}
			
			in = new ByteArrayInputStream(b);
			int d=0;
			System.out.print("\n");
			while((d=in.read())!=-1) {
				System.out.print((char)d);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		File out= new File("C:\\Mywork\\Java\\output\\testoutput.dat");
		try {
			if(!out.exists()) {
				out.createNewFile();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		long startTime= System.currentTimeMillis();
		copyWithFileStream(new File("C:\\Mywork\\Personal\\Newfolder\\GH011113.MP4"), out);
		long endTime=System.currentTimeMillis();
		System.out.printf("\nTime elapse:%d, Buffer size:%d",endTime-startTime, BUF_SIZE );
		
		startTime= System.currentTimeMillis();
		copyWithBufferedStream(new File("C:\\Mywork\\Personal\\Newfolder\\GH011113.MP4"), out);
		endTime=System.currentTimeMillis();
		System.out.printf("\nTime elapse:%d, Buffer size:%d",endTime-startTime, BUF_SIZE );
		//System.out.printf("The buffer size %d in String is: %s",count, in.));
		//BufferedReader test = new BufferedReader(new InputStreamReader(System.in));
		//String str= test.readLine();
		//System.out.println(str);
		 * 
		 * 
		 */
	}
}