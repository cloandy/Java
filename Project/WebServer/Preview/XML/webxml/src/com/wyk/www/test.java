/*
 * SRX解析XML文件，并且反射
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

// sax 只用于解析数据，不用于修改xml数据
public class test
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
        WebSaxHanlder handler =  new WebSaxHanlder();
        xmlReader.setContentHandler(handler);
        
        /*[5]. 解析xml文件*/
        xmlReader.parse("src\\com\\wyk\\www\\WebXml.xml");
        /*[6]. 显示信息,到别的类中进行处理*/
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

/* 要用sax解析xml文档 需要自己去实现一个事件处理器*/
/* 事件处理器会有一些事件的callback函数，需要我们去重写*/

class WebSaxHanlder extends DefaultHandler{
	
	private List<Entity> entities;
	private List<Mapping> mappings;
	
	private Entity entity;
	private Mapping mapping;
	
	private String tag; /*存储操作标签*/
	private boolean isMapping = false; /*存储操作标签*/
	
	@Override
	public void startDocument() {
		System.out.println("----文档解析开始----");
		entities = new ArrayList<Entity>();
		mappings = new ArrayList<Mapping>();
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
			System.out.println("内容为 -> " + contents);
		}
		if(null != tag) {
			if(isMapping) { /*操作Mapping*/
				if(tag.equals("servlet-name")) {
					mapping.setName(contents);
				}else if(tag.equals("url-pattern")) {
					mapping.addPattern(contents);
				}
			}else { /*操作servlet*/
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
		
		System.out.println(qName + "-->文档解析结束");
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
		System.out.println("----文档解析结束----");
	}
	
	public List<Entity> getEntities(){
		return entities;
	}
	
	
	public List<Mapping> getMappings(){
		return mappings;
	}
}
