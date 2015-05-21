package org.study.designpattern.ch12.fruitfactory;

public class FruitGardener {
	public static Fruit factory(String fruit) throws BadFruitException{
		if(fruit.equals("apple")){
			return new Apple();
		}else if(fruit.equals("grape")){
			return new Grape();
		}else if(fruit.equals("strawberry")){
			return new Strawberry();
		}else{
			throw new BadFruitException("Bad fruit request.");
		}
	}
}
