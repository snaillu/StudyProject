package com.snail.algorithm.chapter8;

import java.util.Iterator;

import com.snail.algorithm.chapter7.Position;

public interface Tree<E> extends Iterable<E> {
	Position<E> root();
	Position<E> parent(Position<E> p) throws IllegalArgumentException;
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
	int numChildren(Position<E> p) throws IllegalArgumentException;
	boolean isInternal(Position<E> p) throws IllegalArgumentException;
	boolean isExternal(Position<E> p) throws IllegalArgumentException;
	boolean isRoot(Position<E> p) throws IllegalArgumentException;
	int size();
	boolean isEmpty();
	Iterator<E> iterator();
	Iterator<Position<E>> positions();
}
