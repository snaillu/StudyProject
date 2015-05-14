package org.study.java.io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
	public static void main(String[] args) throws IOException {
		StringReader sr = new StringReader(InputStreamTest.read("src/main/java/org/study/java/io/InputStreamTest.java"));
		int c;
		while((c=sr.read())!=-1)
			System.out.print((char)c);
	}
}
