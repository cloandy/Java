/*
 * SRX����XML�ļ������ҷ���
 * */
package com.wyk.www;

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
public class test
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
        WebSaxHanlder handler =  new WebSaxHanlder();
        xmlReader.setContentHandler(handler);
        
        /*[5]. ����xml�ļ�*/
        xmlReader.parse("src\\com\\wyk\\www\\WebXml.xml");
        /*[6]. ��ʾ��Ϣ,��������н��д���*/
        WebContext webcontext = new WebContext(handler.getEntities(), handler.getMappings());
        String className = webcontext.getClz("/g");
        Class clz = Class.forName(className);
        Servlet servlet = (Servlet)clz.getConstructor().newInstance();
        System.out.println(servlet);
        servlet.service();
        
        

        
//        List<Entity> entities = handler.getEntities();
//        System.out.println(entities.size());
////        for(Entity p : entities) {
////        	System.out.println(p.getName() + " " + p.getClz());
////        }
//        List<Mapping> mappings = handler.getMappings();
//        System.out.println(mappings.size());
////        for(Mapping p : mappings) {
////        	System.out.println(p.getName() + " " + p.getPatterns());
////        }
        
    }
}

/* Ҫ��sax����xml�ĵ� ��Ҫ�Լ�ȥʵ��һ���¼�������*/
/* �¼�����������һЩ�¼���callback��������Ҫ����ȥ��д*/

class WebSaxHanlder extends DefaultHandler{
	
	private List<Entity> entities;
	private List<Mapping> mappings;
	
	private Entity entity;
	private Mapping mapping;
	
	private String tag; /*�洢������ǩ*/
	private boolean isMapping = false; /*�洢������ǩ*/
	
	@Override
	public void startDocument() {
		System.out.println("----�ĵ�������ʼ----");
		entities = new ArrayList<Entity>();
		mappings = new ArrayList<Mapping>();
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
			if(qName.equals("servlet")) {
				entity = new Entity();
				isMapping = false;
			}else if(qName.equals("servlet-mapping")) {
				mapping = new Mapping();
				isMapping = true;
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
		if(null != tag) {
			if(isMapping) { /*����Mapping*/
				if(tag.equals("servlet-name")) {
					mapping.setName(contents);
				}else if(tag.equals("url-pattern")) {
					mapping.addPattern(contents);
				}
			}else { /*����servlet*/
				if(tag.equals("servlet-name")) {
					entity.setName(contents);
				}else if(tag.equals("servlet-class")) {
					entity.setClz(contents);
				}
				
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName,String qName ) {
		
		System.out.println(qName + "-->�ĵ���������");
		if(qName != null) {
			System.out.println(tag);
			if(qName.equals("servlet")) {
				entities.add(entity);
			}else if(qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			}
		}
		tag = null;
	}
	
	@Override
	public void endDocument() {
		System.out.println("----�ĵ���������----");
	}
	
	public List<Entity> getEntities(){
		return entities;
	}
	
	
	public List<Mapping> getMappings(){
		return mappings;
	}
}
