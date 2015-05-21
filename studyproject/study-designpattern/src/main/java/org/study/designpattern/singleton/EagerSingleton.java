package org.study.designpattern.singleton;

public class EagerSingleton {
	private static final EagerSingleton m_instance = new EagerSingleton();
	
	private EagerSingleton(){}
	
	public static EagerSingleton getInstance(){
		return m_instance;
	}
}
