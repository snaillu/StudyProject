package org.study.designpattern.ch12.methodfactory;

public class ConcreteCreator2 implements Creator {

	public Product factory() {
		return new ConcreteProduct2();
	}

}
