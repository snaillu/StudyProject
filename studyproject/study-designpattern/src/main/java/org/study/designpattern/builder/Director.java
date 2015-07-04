package org.study.designpattern.builder;

public class Director {
	private Builder builder = new ConcreteBuilder();
	
	public Director(){
		builder.builderPart1();
		builder.builderPart2();
		builder.retrieveResult();
	}
}
