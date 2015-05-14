package org.study.mongodb;

public class Person {
	static{
		System.out.println("this is person static block.");
	}
	
	{
		System.out.println("this is person");
	}
	public Person(int id){
		System.out.println("This is person id:"+id);
	}
}
