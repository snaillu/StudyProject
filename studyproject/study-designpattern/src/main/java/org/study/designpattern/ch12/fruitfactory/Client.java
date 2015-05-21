package org.study.designpattern.ch12.fruitfactory;

public class Client {
	public static void main(String[] args) {
		Fruit fruit = null;
		try {
			fruit = FruitGardener.factory("apple");
			fruit.harvest();
			
			fruit = FruitGardener.factory("orange");
		} catch (BadFruitException e) {
			e.printStackTrace();
		}
	}
}
