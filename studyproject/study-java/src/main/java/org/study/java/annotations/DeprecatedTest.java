package org.study.java.annotations;

@Deprecated
public class DeprecatedTest {
	private DeprecatedTest(){}
	
	public static DeprecatedTest getInstance(){
		DeprecatedTest dt = new DeprecatedTest();
		return dt;
	}
}
