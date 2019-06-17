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
		
		/*[1].新建SAXReader对象，用于读取xml文件*/
		SAXReader reader = new SAXReader();
		
		/*[2]. 读取xml文件，得到Docment对象*/
		Document doc = reader.read(new File("src/test/test.xml"));
		System.out.println(doc);
		
		/*[3]. 获取根元素*/
		Element rootElement = doc.getRootElement();
		System.out.println(rootElement.getName());
		
		/*[4]. 获取根元素下所有子元素*/
		Iterator<Element> iterator = rootElement .elementIterator();
		
		while(iterator.hasNext()) {
			/*取出元素*/
			Element element = iterator.next();
			System.out.print(element.getName());
			
			/*获取属性*/
			Attribute idAttribute = element.attribute("id");
			System.out.print(" " + idAttribute.getName() + " = " + idAttribute.getValue());
			
			/*获取person的子元素*/
			Element name = element.element("name");
			Element age = element.element("age");
			
			System.out.println(" " + name.getStringValue() + age.getStringValue());
		}
	} 

}
