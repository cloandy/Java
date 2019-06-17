/*
 * SRX��ʽ����xml�ļ������Ҵ洢��Ϣ
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

// sax ֻ���ڽ������ݣ��������޸�xml����
public class testSAX
{
       public static void main(String[] args) throws Exception, SAXException
    {
        /*[1]. ʹ��SAXParserFactory����SAX�������� */
        SAXParserFactory spf = SAXParserFactory.newInstance();
        
        /*[2]. ͨ��SAX���������õ����������� */
        SAXParser sp = spf.newSAXParser();
        
        /*[3]. ͨ������������õ�һ��XML�Ķ�ȡ��*/
        XMLReader xmlReader = sp.getXMLReader();
        
        /*[4]. ���ö�ȡ�����¼�������*/
        MySaxHanlder handler =  new MySaxHanlder();
        xmlReader.setContentHandler(handler);
        
        /*[5]. ����xml�ļ�*/
        xmlReader.parse("src/xml2/score.xml");
        /*[6]. ��ʾ��Ϣ*/
        List<Person> persons = handler.getPersons();
        System.out.println(persons.size());
        for(Person p : persons) {
        	System.out.println(p.getName() + " " + p.getAge());
        }
    }
}

/* Ҫ��sax����xml�ĵ� ��Ҫ�Լ�ȥʵ��һ���¼�������*/
/* �¼�����������һЩ�¼���callback��������Ҫ����ȥ��д*/

class MySaxHanlder extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	private String tag; /*�洢������ǩ*/
	
	@Override
	public void startDocument() {
		System.out.println("----�ĵ�������ʼ----");
		persons = new ArrayList<Person>();
	}
	
	@Override
	/*startElement(String uri,String localName,String qName,Attributes attributes) 
	 * qName �޶���������
	 * attributes Ԫ�ص�����
	 */
	public void startElement(String uri,String localName,String qName,Attributes attributes) {
		System.out.println(qName + "-->�ĵ�������ʼ");
		if(null != qName) {
			
			tag = qName; /*�洢��ǩ����*/
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
			System.out.println("����Ϊ -> " + contents);
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
		
		System.out.println(qName + "-->�ĵ���������");
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
		System.out.println("----�ĵ���������----");
	}
	
	public List<Person> getPersons(){
		return persons;
	}
}
