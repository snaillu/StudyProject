package com.snail.algorithm.chapter03;

public class DoubleLinkedList<E> {
	private static class Node<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node(E e,Node<E> p,Node<E> n){
			element = e;
			prev = p;
			next = n;
		}
		public E getElement(){return element;}
		public Node<E> getPrev(){return prev;}
		public Node<E> getNext(){return next;}
		public void setPrev(Node<E> p){prev = p;}
		public void setNext(Node<E> n){next = n;}
	}
	
	//instance variables of the DoublyLinkedList
	private Node<E> header;
	private Node<E> tailer;
	private int size = 0;
	//constructs
	public DoubleLinkedList(){
		header = new Node<E>(null,null,null);
		tailer = new Node<E>(null,header,null);
		header.setNext(tailer);
	}
	
	public int size(){return size;}
	public boolean isEmpty(){return size==0;}
	public E first(){
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}
	public E last(){
		if(isEmpty()) return null;
		return tailer.getPrev().getElement();
	}
	public void addFirst(E e){
		addBetween(e,header,header.getNext());
	}
	public void addLast(E e){
		addBetween(e,tailer.getPrev(),tailer);
	}
	public E removeFirst(){
		if(isEmpty()) return null;
		return remove(header.getNext());
	}
	public E removeLast(){
		if(isEmpty()) return null;
		return remove(tailer.getPrev());
	}
	private void addBetween(E e,Node<E> predecessor,Node<E> successor){
		Node<E> newest = new Node<E>(e,predecessor,successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	private E remove(Node<E> node){
		Node<E> predesscessor = node.getPrev();
		Node<E> successor = node.getNext();
		predesscessor.setNext(successor);
		successor.setPrev(predesscessor);
		size--;
		return node.getElement();
	}
}
