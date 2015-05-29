package org.appress.hibernate.ch02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGES_TB")
public class Message {
	private Long id;
	private String text;
	
	Message(){}
	
	public Message(String text){
		this.text = text;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MESSAGE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
