package com.snail.algorithm.chapter9;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {

	public int compare(E o1, E o2) throws ClassCastException {
		return ((Comparable<E>)o1).compareTo(o2);
	}
}
