package com.snail.spring.ch08.dao.plain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.snail.spring.ch08.dao.ContactDao;
import com.snail.spring.ch08.domain.Contact;
import com.snail.spring.ch08.domain.ContactTelDetail;

public class JdbcContactDao implements ContactDao, InitializingBean {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class ContactMapper implements RowMapper<Contact>{
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			
			return contact;
		}
	}
	
	private static class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>>{

		public List<Contact> extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			Map<Long,Contact> map = new HashMap<Long,Contact>();
			
			Contact contact = null;
			while(rs.next()){
				Long id = rs.getLong("id");
				contact = map.get(id);
				if(contact == null){
					contact = new Contact();
					contact.setId(id);
					contact.setFirstName(rs.getString("first_name"));
					contact.setLastName(rs.getString("last_name"));
					contact.setBirthDate(rs.getDate("birth_date"));
					contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
					map.put(id, contact);
				}
				
				Long contactTelDetailId = rs.getLong("contact_tel_id");
				if(contactTelDetailId>0){
					ContactTelDetail detail = new ContactTelDetail();
					detail.setId(contactTelDetailId);
					detail.setContactId(id);
					detail.setTelNumber(rs.getString("tel_number"));
					detail.setTelType(rs.getString("tel_type"));
					contact.getContactTelDetails().add(detail);
				}
			}
			return new ArrayList<Contact>(map.values());
		}
	}
	
	public String findFirstNameById(Long id){
		String firstName = jdbcTemplate.queryForObject(
				"select first_name from contact where id=?", new Object[]{id},String.class);
		
		return firstName;
	}
	
	public List<Contact> findAll() {
		String sql = "select id,first_name,last_name,birth_date from contact";
		return jdbcTemplate.query(sql, new ContactMapper());
	}

	public List<Contact> findByFirstName(String name) {
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

	public void afterPropertiesSet() throws Exception {
		if(dataSource==null)
			throw new BeanCreationException("must set dataSource on ContactDao");
	}

	public List<Contact> findWithAllDetail() {
		String sql = "select c.id,c.first_name,c.last_name,c.birth_date,t.id as contact_tel_id,t.tel_type"
				+ ",t.tel_number from contact c left join contact_tel_detail t on c.id=t.contact_id";
		
		return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
	}

}
