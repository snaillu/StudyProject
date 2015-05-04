package com.snail.algorithm.chapter06;

public interface Stack<E> {
	//return the number of elements in the stack
	int size();
	//return true if the stack is  empty, false otherwise
	boolean isEmpty();
	//insert an element at the top of the stack
	void push(E e);
	//returns, but does not remove, the element at the top
	E top();
	//removes and returns the top element from the stack
	E pop();
}
