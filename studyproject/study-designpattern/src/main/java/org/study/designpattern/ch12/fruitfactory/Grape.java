package org.study.designpattern.ch12.fruitfactory;

public class Grape implements Fruit {
	private boolean seedless;
	
	public void plant() {
		log("grape plant");
	}

	public void grow() {
		log("apple grow");
	}

	public void harvest() {
		log("apple harvest");
	}

	public boolean isSeedless() {
		return seedless;
	}

	public void setSeedless(boolean seedless) {
		this.seedless = seedless;
	}
	
	private void log(String msg){
		System.out.println(msg);
	}
}
