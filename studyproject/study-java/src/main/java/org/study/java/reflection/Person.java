package org.study.java.reflection;

import java.io.Serializable;

public class Person implements Cloneable, Serializable {
	private int id = -1;
	private String name = "Unknown";
	
	public Person(){}
	
	public Person(int id,String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}
