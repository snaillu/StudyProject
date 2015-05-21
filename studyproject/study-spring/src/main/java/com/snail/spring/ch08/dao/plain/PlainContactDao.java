package com.snail.spring.ch08.dao.plain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.snail.spring.ch08.dao.ContactDao;
import com.snail.spring.ch08.domain.Contact;

public class PlainContactDao implements ContactDao {

	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","snail");
	}
	
	private void closeConnection(Connection conn){
		if(conn==null) return;
		
		try{
			conn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public List<Contact> findAll() {
		List<Contact> result = new ArrayList<Contact>();
		
		Connection conn = null;
		return null;
	}

	public List<Contact> findByFirstName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	public void update(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long contactId) {
		// TODO Auto-generated method stub
		
	}

}
