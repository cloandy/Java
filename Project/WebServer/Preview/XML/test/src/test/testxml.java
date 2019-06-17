package test;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
public class testxml {

	public static void main(String[] args) throws DocumentException {
		
		/*[1].�½�SAXReader�������ڶ�ȡxml�ļ�*/
		SAXReader reader = new SAXReader();
		
		/*[2]. ��ȡxml�ļ����õ�Docment����*/
		Document doc = reader.read(new File("src/test/test.xml"));
		System.out.println(doc);
		
		/*[3]. ��ȡ��Ԫ��*/
		Element rootElement = doc.getRootElement();
		System.out.println(rootElement.getName());
		
		/*[4]. ��ȡ��Ԫ����������Ԫ��*/
		Iterator<Element> iterator = rootElement .elementIterator();
		
		while(iterator.hasNext()) {
			/*ȡ��Ԫ��*/
			Element element = iterator.next();
			System.out.print(element.getName());
			
			/*��ȡ����*/
			Attribute idAttribute = element.attribute("id");
			System.out.print(" " + idAttribute.getName() + " = " + idAttribute.getValue());
			
			/*��ȡperson����Ԫ��*/
			Element name = element.element("name");
			Element age = element.element("age");
			
			System.out.println(" " + name.getStringValue() + age.getStringValue());
		}
	} 

}
