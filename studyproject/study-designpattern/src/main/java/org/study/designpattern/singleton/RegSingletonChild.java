package org.study.designpattern.singleton;

public class RegSingletonChild extends RegSingleton {
	public RegSingletonChild(){}
	
	static public RegSingletonChild getInstance(){
		return (RegSingletonChild)RegSingleton.getInstance("org.study.designpattern.singleton.RegSingletonChild");
	}
	
	public String about(){
		return "Hello, I am RegSingletonChild.";
	}
}
