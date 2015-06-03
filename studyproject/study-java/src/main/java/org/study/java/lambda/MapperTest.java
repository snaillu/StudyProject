package org.study.java.lambda;

public class MapperTest {
	public static void main(String[] args) {
		System.out.println("Mapping names to their lengths:");
		String[] names = {"David","Merry","Jun","Mac Jackson"};
		int[] lengthMapping = Mapper.mapToInt(names, (String name)->name.length());
		printMapping(names,lengthMapping);
		
		System.out.println("\nMapping integers to their square:");
		Integer[] numbers = {8,34,120};
		int[] countMapping = Mapper.mapToInt(numbers, (Integer n)->n*n);
		printMapping(numbers, countMapping);
		
	}
	
	public static void printMapping(Object[] from,int[] to){
		for(int i=0;i<from.length;i++){
			System.out.println(from[i] +" mapped to "+to[i]);
		}
	}
}
