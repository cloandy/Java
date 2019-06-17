/*
 * SRX方式解析xml文件，并且存储信息
 * */
package xml2;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

// sax 只用于解析数据，不用于修改xml数据
public class testSAX
{
       public static void main(String[] args) throws Exception, SAXException
    {
        /*[1]. 使用SAXParserFactory创建SAX解析工厂 */
        SAXParserFactory spf = SAXParserFactory.newInstance();
        
        /*[2]. 通过SAX解析工厂得到解析器对象 */
        SAXParser sp = spf.newSAXParser();
        
        /*[3]. 通过解析器对象得到一个XML的读取器*/
        XMLReader xmlReader = sp.getXMLReader();
        
        /*[4]. 设置读取器的事件处理器*/
        MySaxHanlder handler =  new MySaxHanlder();
        xmlReader.setContentHandler(handler);
        
        /*[5]. 解析xml文件*/
        xmlReader.parse("src/xml2/score.xml");
        /*[6]. 显示信息*/
        List<Person> persons = handler.getPersons();
        System.out.println(persons.size());
        for(Person p : persons) {
        	System.out.println(p.getName() + " " + p.getAge());
        }
    }
}

/* 要用sax解析xml文档 需要自己去实现一个事件处理器*/
/* 事件处理器会有一些事件的callback函数，需要我们去重写*/

class MySaxHanlder extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	private String tag; /*存储操作标签*/
	
	@Override
	public void startDocument() {
		System.out.println("----文档解析开始----");
		persons = new ArrayList<Person>();
	}
	
	@Override
	/*startElement(String uri,String localName,String qName,Attributes attributes) 
	 * qName 限定的名称名
	 * attributes 元素的属性
	 */
	public void startElement(String uri,String localName,String qName,Attributes attributes) {
		System.out.println(qName + "-->文档解析开始");
		if(null != qName) {
			
			tag = qName; /*存储标签名称*/
			System.out.println(tag);
			if(qName.equals("person")) {
				person = new Person();
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String contents = new String(ch, start, length).trim();
		if(contents.length() > 0) {
			System.out.println("内容为 -> " + contents);
		}
		System.out.println("char" + tag);
		if(null != tag) {
			if(tag.equals("name")) {
				person.setName(contents);
			}else if(tag.equals("age")) {
				if(contents.length() > 0)
					person.setAge(Integer.valueOf(contents));
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName,String qName ) {
		
		System.out.println(qName + "-->文档解析结束");
		if(qName != null) {
			System.out.println(tag);
			if(qName.equals("person")) {
				persons.add(person);
			}
		}
		tag = null;
	}
	
	@Override
	public void endDocument() {
		System.out.println("----文档解析结束----");
	}
	
	public List<Person> getPersons(){
		return persons;
	}
}
