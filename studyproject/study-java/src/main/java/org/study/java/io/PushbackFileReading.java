package org.study.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackFileReading {
	public static void main(String[] args) {
		String destFile = "snail2.txt";
		
		try(PushbackInputStream pis = new PushbackInputStream(new FileInputStream(destFile))){
			byte byteData;
			
			while((byteData=(byte)pis.read())!=-1){
				System.out.print((char)byteData);
				
				pis.unread(byteData);
				
				byteData=(byte)pis.read();
				System.out.print((char)byteData);
			}
		}catch(FileNotFoundException e){
			FileUtil.printFileNotFoundMsg(destFile);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
