package org.study.designpattern.ch12.fruitfactory;

public class Apple implements Fruit {
	private int treeAge;
	
	public void plant() {
		log("apple plant.");
	}

	public void grow() {
		log("Apple grow");
	}

	public void harvest() {
		log("Apple harvest");
	}

	public int getTreeAge() {
		return treeAge;
	}

	public void setTreeAge(int treeAge) {
		this.treeAge = treeAge;
	}
	
	private void log(String msg){
		System.out.println(msg);
	}
}
