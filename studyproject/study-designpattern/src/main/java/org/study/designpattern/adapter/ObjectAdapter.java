package org.study.designpattern.adapter;

public class ObjectAdapter implements Target {
	private Adaptee adaptee;
	
	public ObjectAdapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}
	
	public void sampleOperation1() {
		adaptee.sampleOperation1();
	}

	public void sampleOperation2() {
		System.out.println("sampleOperation2");
	}

}
