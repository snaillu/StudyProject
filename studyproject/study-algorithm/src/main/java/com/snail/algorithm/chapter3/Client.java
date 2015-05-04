package com.snail.algorithm.chapter3;

public class Client {
	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addFirst("Test1");
		list.addLast("Test2");
		
		System.out.println("size="+list.size()+"  first="+list.first());
	}
}
