package org.study.designpattern.ch12.simplefactory;

public class Creator {
	public static Product factory(){
		return new ConcreteProduct();
	}
}
