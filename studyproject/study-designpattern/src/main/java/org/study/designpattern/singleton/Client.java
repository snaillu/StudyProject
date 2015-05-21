package org.study.designpattern.singleton;

import java.io.IOException;


public class Client {
	public static void main(String[] args) throws IOException {
//		ConfigManager manager = ConfigManager.getInstance();
//		System.out.println(manager.getConfigItem("username", "Today"));
		
		Process proc = Runtime.getRuntime().exec("notepad.exe");
	}
}
