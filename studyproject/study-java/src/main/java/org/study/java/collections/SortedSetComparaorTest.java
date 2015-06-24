package org.study.java.collections;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetComparaorTest {
	public static void main(String[] args) {
		SortedSet<Person> personsById = new TreeSet<Person>(Comparator.comparing(Person::getId));
		
		personsById.add(new Person(3,"snail"));
		personsById.add(new Person(5,"Merry"));
		personsById.add(new Person(1,"John"));
		personsById.add(new Person(2,"June"));
		personsById.add(new Person(2,"June"));
		
		System.out.println("Persons by Id: ");
		personsById.forEach(System.out::println);
	}
}
