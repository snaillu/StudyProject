package com.snail.spring.ch08.dao.plain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		try{
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("select * from contact");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Contact contact = new Contact();
				contact.setId(resultSet.getLong("id"));
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));
				contact.setBirthDate(resultSet.getDate("birth_date"));
				
				result.add(contact);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeConnection(conn);
		}
		
		return result;
	}

	public List<Contact> findByFirstName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Contact contact) {
		Connection conn = null;
		
		try{
			String sql="insert into contact(first_name,last_name,birth_date) values(?,?,?)";
			
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.setDate(3, contact.getBirthDate());
			statement.execute();
			
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if(generatedKeys.next()){
				contact.setId(generatedKeys.getLong(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeConnection(conn);
		}
	}

	public void update(Contact contact) {
	}

	public void delete(Long contactId) {
		Connection conn = null;
		
		try{
			String sql = "delete from contact where id=?";
			
			conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, contactId);
			statement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeConnection(conn);
		}
	}

	public String findFirstNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contact> findWithAllDetail() {
		// TODO Auto-generated method stub
		return null;
	}

}
