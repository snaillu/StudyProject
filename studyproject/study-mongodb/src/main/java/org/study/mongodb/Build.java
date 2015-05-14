package org.study.mongodb;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.mainEntityPersisterReference_return;

public class Build {
	static{
		System.out.println("This is a static block.");
	}
	{
		System.out.println("This is a no-static block.");
	}
	
	Person p1 = new Person(1);
	public Build(){
		System.out.println("This is build.");
		Person p3 = new Person(3);
	}
	Person p2 = new Person(2);
	
	public static void main(String[] args) {
		Build b = new Build();
	}
}
