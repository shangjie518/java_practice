package XML;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlOpsDemo2 {

	private File xmlFile;
	private Document xmlDoc;

	public XmlOpsDemo2() {
		xmlDoc = this.createDocument();
	}
	
	public XmlOpsDemo2(File in) {
		xmlFile=in;
		
	}

	public Document createDocument() {

		Document xml = DocumentHelper.createDocument();
		xml.setXMLEncoding("UTF-8");
		Element root = xml.addElement("RemoteConfig");
		Element config1 = root.addElement("Config");
		config1.addElement("Name").addText("route settings");
		config1.addElement("Value").addText("avoid ferries");

		Element config2 = root.addElement("Config");
		config2.addElement("Name").addText("date and time");
		config2.addElement("Value").addText("time format");

		return xml;

	}
	
	public void xmlReader() {
		SAXReader reader= new SAXReader();
		try {
			xmlDoc= reader.read(this.xmlFile);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element root= xmlDoc.getRootElement();
		Iterator<Element> it= root.elementIterator();
		while(it.hasNext()) {
			Element e= it.next();
			System.out.println(e.getName());
			System.out.println(e.getStringValue());
		}
	}

	public void test() {
		Writer writer = new StringWriter();
		try {
			xmlDoc.write(writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(writer.toString());
	}

	public static void main(String[] args) {
		new XmlOpsDemo2().test();
		File xmlfile=new File("C:\\Mywork\\Java\\output\\inputDemo.xml");
		XmlOpsDemo2 xml=new XmlOpsDemo2(xmlfile);
		xml.xmlReader();
	}
}
