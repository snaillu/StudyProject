package org.study.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class PersonDeserializationTest {
	public static void main(String[] args) {
		File fileObject = new File("person.ser");
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileObject))){
			Person john = (Person)ois.readObject();
			Person snail = (Person)ois.readObject();
			//Person merry = (Person)ois.readObject();
			
			
			System.out.println(john);
			System.out.println(snail);
			//System.out.println(merry);
		}catch(FileNotFoundException e){
			FileUtil.printFileNotFoundMsg(fileObject.getAbsolutePath());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
