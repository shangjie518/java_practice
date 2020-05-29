package XML;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlOpsDemo {
	
	private File xmlFile;
	
	public XmlOpsDemo(File in) {
		xmlFile=in;
	}
	
	public void xmlReader(String inputXml) {
		DocumentBuilder builder;
		String tagname=new String();
		try {
			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
			builder= factory.newDocumentBuilder();
			Document doc = builder.parse(String2Stream(inputXml));
			NodeList nodes=doc.getChildNodes();
			
			nodesList(nodes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private InputStream String2Stream(String input) {
		ByteArrayInputStream res=new ByteArrayInputStream(input.getBytes());
		return res;
	}
		
	private String xmlHandler(String content) {
		String regex= "\\s{2,}|\\t|\\n|\\r";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(content);
		content= m.replaceAll("");
		return content;
		
	}	
	private String xmlRead2Str() throws IOException {
		StringBuilder res=new StringBuilder();
		BufferedReader reader= new BufferedReader(new FileReader(xmlFile));
		String line;
		while((line=reader.readLine())!=null){
			res.append(line);
		}
		return res.toString();
	}	
	
	private void printNode(Node node) {
		System.out.printf("%s= %s\n",node.getNodeName(),node.getNodeValue());
	}
	
	private void nodesList(NodeList nodes) {
		if (nodes.getLength() != 0) {
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				printNode(node);
				NodeList childs = node.getChildNodes();
				nodesList(childs);
			}

		}

	}
	
	public void test() {
		try {
			String str= this.xmlRead2Str();
			str=this.xmlHandler(str);
			System.out.println(str);
			this.xmlReader(str);
			//System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		File xmlfile=new File("C:\\Mywork\\Java\\output\\inputDemo.xml");
		XmlOpsDemo xml=new XmlOpsDemo(xmlfile);
		xml.test();
	}

}
