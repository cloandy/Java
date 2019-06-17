package com.wyk.www;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
	private List<Entity> entities = null;
	private List<Mapping> mappings = null;
	
	/*�����϶���ת��ΪMap��*/
	/*K --> Servlet-name  V --> Servlet-class*/
	private Map<String,String>entityMap = new HashMap<String, String>();
	/*K --> url-pattern  V --> Servlet-name*/
	private Map<String,String>mappingMap = new HashMap<String, String>();
	
	public WebContext(List<Entity> entities, List<Mapping> mappings) {
		super();
		this.entities = entities;
		this.mappings = mappings;
		/*��entity��Listת��ΪMap*/
		for(Entity entity : entities) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		//*��Mapping��Listת��ΪMap*/
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
	 * ͨ����Ӧ��URL���ҵ���Ӧ��class
	 *��ʽ���
	 */
	public String getClz(String pattern) {
		
		return entityMap.get(mappingMap.get(pattern));
	}
	
	
}
