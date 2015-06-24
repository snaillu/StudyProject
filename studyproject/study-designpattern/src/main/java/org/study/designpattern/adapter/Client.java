package org.study.designpattern.adapter;

public class Client {
	public static void main(String[] args) {
		Target t = new Adapter();
		t.sampleOperation1();
		t.sampleOperation2();
		
		Adaptee a = new Adaptee();
		Target t1 = new ObjectAdapter(a);
		
		t1.sampleOperation1();
		t1.sampleOperation2();
		
	}
}
