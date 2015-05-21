package org.study.designpattern.ch12.methodfactory;

public class ConcreteCreator1 implements Creator {

	public Product factory() {
		return new ConcreteProduct1();
	}

}
