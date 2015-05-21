package org.study.designpattern.ch12.abstractfactory;

public class ConcreteCreator1 implements Creator {

	public Product factoryA() {
		return new ProductA1();
	}

	public Product factoryB() {
		return new ProductB1();
	}

}
