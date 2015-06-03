package org.study.java.innerclass;

import org.study.java.innerclass.A.B;

public class Client {
	public static void main(String[] args) {
		Client c = new Client();
		c.Out2Test();
	}
	
	public void Out2Test(){
		Outer2 out = new Outer2();
		Outer2.Inner inner = out.new Inner();
		
		out.printValue();
		inner.printValue();
		
		out.setValue(1988);
		
		out.printValue();
		inner.printValue();
	}
	
	public void Out1Test(){
		Outer1 out = new Outer1();
		Outer1.Inner inner = out.new Inner();
		
		out.printValue();
		inner.printValue();
		
		out.setValue(1222);
		
		out.printValue();
		inner.printValue();
	}
	
	public void OutTest(){
		A.B b = new A.B();
		System.out.println(b.toString());
		
		B b1 = new B();
		System.out.println(b1.toString());
		
		Outer out = new Outer();
		Outer.Inner i = out.new Inner();
	}
	
	public void OutATest(){
		OuterA out = new OuterA();
		OuterA.InnerA innerA = out.new InnerA();
		OuterA.InnerA.InnerAA innerAA = innerA.new InnerAA();
		OuterA.InnerA.InnerAA.InnerAAA innerAAA = innerAA.new InnerAAA();
	}
}
