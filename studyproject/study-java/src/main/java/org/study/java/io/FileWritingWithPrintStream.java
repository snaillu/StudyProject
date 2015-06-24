package org.study.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileWritingWithPrintStream {
	public static void main(String[] args) {
		String destFile = "snail3.txt";
		
		try(PrintStream ps = new PrintStream(new FileOutputStream(destFile))){
			ps.println("This is the first line.");
			ps.println("This is the second line.");
			ps.println("This is the third line.");
			ps.print("This is the forth line.");
			ps.print("This is the fifth line.");
			
			ps.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			FileUtil.printFileNotFoundMsg(destFile);
		}
	}
}
