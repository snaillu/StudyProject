package org.study.designpattern.singleton;

public class LazySingleton {
	private static LazySingleton m_instance = null;
	
	private LazySingleton(){}
	
	synchronized public static LazySingleton getInstance(){
		return m_instance;
	}
}
