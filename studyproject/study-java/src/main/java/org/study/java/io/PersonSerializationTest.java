package org.study.java.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonSerializationTest {
	public static void main(String[] args) {
		Person john = new Person("John","Male",9.1);
		//Person snail = new Person("Snail","Male",12.0);
		//Person merry = new Person("Merry","Female",11.1);
		
		
		File fileObject = new File("person.ser");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileObject))){
			oos.writeObject(john);
			//oos.writeObject(snail);
			//oos.writeObject(merry);
			
			System.out.println(john);
			john.setName("John Smit");
			john.setHeight(19.22);
			
			oos.writeObject(john);
			
			//System.out.println(snail);
			//System.out.println(merry);
			
			System.out.println("Objects were written to "+fileObject.getAbsolutePath());
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
