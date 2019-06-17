package com.wyk.www;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
	private List<Entity> entities = null;
	private List<Mapping> mappings = null;
	
	/*将集合对象，转换为Map类*/
	/*K --> Servlet-name  V --> Servlet-class*/
	private Map<String,String>entityMap = new HashMap<String, String>();
	/*K --> url-pattern  V --> Servlet-name*/
	private Map<String,String>mappingMap = new HashMap<String, String>();
	
	public WebContext(List<Entity> entities, List<Mapping> mappings) {
		super();
		this.entities = entities;
		this.mappings = mappings;
		/*将entity的List转换为Map*/
		for(Entity entity : entities) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		//*将Mapping的List转化为Map*/
		for(Mapping mapping : mappings) {
			for(String pattern : mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName());
			}
		}
	}

	public WebContext() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 通过相应的URL，找到相应的class
	 *链式编程
	 */
	public String getClz(String pattern) {
		
		return entityMap.get(mappingMap.get(pattern));
	}
	
	
}
