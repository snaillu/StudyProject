package org.study.designpattern.decorator;

public class Client {
	public static void main(String[] args) {
		ConcreteComponent cp = new ConcreteComponent();
		Decotor d = new Decotor(cp);
		
		d.operation();
		
	}
}
