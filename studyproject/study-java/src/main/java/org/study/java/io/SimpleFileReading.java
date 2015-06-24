package org.study.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SimpleFileReading {
	public static void main(String[] args) {
		String dataSourceFile = "D:\\snail.txt";
		try(FileInputStream fin = new FileInputStream(dataSourceFile)){
			byte byteData;
			while((byteData=(byte)fin.read())!=-1){
				System.out.print((char)byteData);
			}
		}catch(FileNotFoundException e){
			FileUtil.printFileNotFoundMsg(dataSourceFile);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
