package org.study.java.io;

import java.io.Serializable;

public class Person implements Serializable {
	private String name = "Unknown";
	private String gender = "Unknown";
	private double height = Double.NaN;
	
	public Person(String name,String gender,double height){
		this.name = name;
		this.gender = gender;
		this.height = height;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", height="
				+ height + "]";
	}
}
