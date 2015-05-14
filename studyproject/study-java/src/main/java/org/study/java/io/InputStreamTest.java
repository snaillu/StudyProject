package org.study.java.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputStreamTest {
	public static void main(String[] args) {
		try {
			System.out.println(read("src/main/java/org/study/java/io/InputStreamTest.java"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String read(String fileName) throws IOException{
		BufferedReader bufReader = new BufferedReader(new FileReader(fileName));
		String str = null;
		StringBuffer sb = new StringBuffer();
		while((str=bufReader.readLine())!=null){
			sb.append(str+"\n");
		}
		bufReader.close();
		
		return sb.toString();
	}
}
