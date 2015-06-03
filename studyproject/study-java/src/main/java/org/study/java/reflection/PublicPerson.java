package org.study.java.reflection;

public class PublicPerson {
	private int id = -1;
	public String name = "Unknown";
	public PublicPerson(){}
	
	@Override
	public String toString() {
		return "PublicPerson [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
