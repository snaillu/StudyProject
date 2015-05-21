package org.study.designpattern.ch12.fruitfactory;

public class Strawberry implements Fruit {

	public void plant() {
		log("strawberry plant");
	}

	public void grow() {
		log("strawberry grow");
	}

	public void harvest() {
		log("strawberry harvet");
	}
	
	private void log(String msg){
		System.out.println(msg);
	}

}
