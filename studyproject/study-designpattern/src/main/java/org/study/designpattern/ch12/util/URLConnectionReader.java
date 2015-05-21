package org.study.designpattern.ch12.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	public static void main(String[] args) throws IOException {
		URL baidu = new URL("http://www.baidu.com");
		URLConnection conn = baidu.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String inputLine;
		while((inputLine=in.readLine())!=null)
			System.out.println(inputLine);
		in.close();
	}
}
