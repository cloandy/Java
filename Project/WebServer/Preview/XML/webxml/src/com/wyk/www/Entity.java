package com.wyk.www;
/**
 * 针对于Servlet来说
 * @author asdw1
 *
 */

public class Entity {
	private String name;
	private String clz;
	
	public Entity(String name, String clz) {
		super();
		this.name = name;
		this.clz = clz;
	}

	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClz() {
		return clz;
	}

	public void setClz(String clz) {
		this.clz = clz;
	}
	
	

}
