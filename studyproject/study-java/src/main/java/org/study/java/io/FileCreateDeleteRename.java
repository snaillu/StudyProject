package org.study.java.io;

import java.io.File;

public class FileCreateDeleteRename {
	public static void printFileDetails(File f){
		System.out.println("Absolute Path: "+f.getAbsolutePath());
		System.out.println("File exists: "+f.exists());
		System.out.println("----------------------------------------");
	}
	
	public static void main(String[] args) {
		try{
			File newFile = new File("my_new_file.txt");
			System.out.println("Before creating the new file:");
			printFileDetails(newFile);
			
			boolean fileCreated = newFile.createNewFile();
			if(!fileCreated){
				System.out.println(newFile+" could not be created.");
			}
			
			System.out.println("After creating the new file:");
			printFileDetails(newFile);
			
			newFile.delete();
			
			
			System.out.println("After deleting the new file");
			printFileDetails(newFile);
			
			newFile.createNewFile();
			
			System.out.println("After recreating the new file:");
			printFileDetails(newFile);
			
			newFile.deleteOnExit();
			System.out.println("After using deleteOnExit() method:");
			printFileDetails(newFile);
			
			File firstFile = new File("my_first_file.txt");
			File secondFile = new File("my_second_file.txt");
			
			fileCreated = firstFile.createNewFile();
			if(fileCreated || firstFile.exists()){
				System.out.println("Before renaming file:");
				printFileDetails(firstFile);
				printFileDetails(secondFile);
				
				boolean renamedFlag = firstFile.renameTo(secondFile);
				if(!renamedFlag){
					System.out.println("Could not rename "+firstFile);
				}
				
				System.out.println("After renaming file:");
				printFileDetails(firstFile);
				printFileDetails(secondFile);
						
			}
		}catch(Exception e){
			
		}
	}
}
