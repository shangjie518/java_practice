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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlOpsDemo {
	
	private File xmlFile;
	private Document xmlDoc;
	
	public XmlOpsDemo(File in) {
		xmlFile=in;
		DocumentBuilder builder;
		try {
			String inputXml = xmlRead2Str();
			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
			builder= factory.newDocumentBuilder();
			xmlDoc = builder.parse(String2Stream(inputXml));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void xmlReader(String inputXml) {
		NodeList nodes=xmlDoc.getChildNodes();
		nodesList(nodes);
	
	}
	
	public void xmlreaderbyElement(String inputXml) {
		Element root=xmlDoc.getDocumentElement();
		System.out.println(root);
		System.out.println(root.getNodeType());
		System.out.println(root.getTextContent());
		NodeList nodes=root.getChildNodes();
		for(int i=0;i<nodes.getLength();i++) {
			System.out.println(nodes.item(i));
			System.out.println(nodes.item(i).getNodeType());
			System.out.println(nodes.item(i).getTextContent());
		}

	}
	
	private InputStream String2Stream(String input) {
		ByteArrayInputStream res=new ByteArrayInputStream(input.getBytes());
		return res;
	}
		
	private String xmlHandler(String content) {
		String regex= "\t|\r|\n";
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
		if(node instanceof Element) {
			System.out.printf("%s= %s\n",node.getNodeName(),node.getTextContent());
		}
		
		
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

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		File xmlfile=new File("C:\\Mywork\\Java\\output\\inputDemo.xml");
		XmlOpsDemo xml=new XmlOpsDemo(xmlfile);
		xml.test();
	}

}
