package org.study.designpattern.singleton;

import java.util.HashMap;

public class RegSingleton {
	static private HashMap m_register = new HashMap();
	static{
		RegSingleton x = new RegSingleton();
		m_register.put(x.getClass().getName(), x);
	}
	
	protected RegSingleton(){}
	
	static public RegSingleton getInstance(String name){
		if(name==null){
			name="org.study.designpattern.singleton.RegSingleton";
		}
		
		if(m_register.get(name)==null){
			try{
				m_register.put(name, Class.forName(name).newInstance());
			}catch(Exception e){
				System.out.println("Error happened.");
			}
		}
		
		return (RegSingleton)(m_register.get(name));
	}
}
