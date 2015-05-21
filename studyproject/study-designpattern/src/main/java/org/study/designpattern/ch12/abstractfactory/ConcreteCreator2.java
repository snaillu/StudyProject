package org.study.designpattern.ch12.abstractfactory;

public class ConcreteCreator2 implements Creator {

	public Product factoryA() {
		return new ProductA2();
	}

	public Product factoryB() {
		return new ProductB2();
	}

}
