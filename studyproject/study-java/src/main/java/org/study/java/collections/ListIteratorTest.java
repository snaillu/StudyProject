package org.study.java.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("SNail");
		list.add("Merry");
		list.add("Jackson");
		list.add("June");
		
		ListIterator iterator = list.listIterator();
		System.out.println();
		System.out.println("List Iterator in forward:");
		
		while(iterator.hasNext()){
			System.out.println("index="+iterator.nextIndex()+" ,element="+iterator.next());
		}
		
		System.out.println();
		System.out.println("List Iterator in backward direction:");
		
		while(iterator.hasPrevious()){
			System.out.println("index="+iterator.previousIndex()+" ,element="+iterator.previous());
		}
	}
}
