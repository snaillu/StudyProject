package org.study.java.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
	public static void main(String[] args) {
		SortedSet<String> sortedNames = new TreeSet<String>();
		
		sortedNames.add("Snail");
		sortedNames.add("Addon");
		sortedNames.add("Merry");
		sortedNames.add("Jack");
		
		System.out.println(sortedNames);
	}
}
