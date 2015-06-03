package org.study.java.innerclass;

public class AccessingLocalVariables {
	public static void main(String[] args) {
		int x = 100;
		final int y = 200;
		
		class LocalInner{
			void print(){
				//System.out.println("x="+x);
				System.out.println("y="+y);
			}
		}
		x= 100;
		LocalInner li = new LocalInner();
		li.print();
	}
}
