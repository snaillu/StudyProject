package com.appress.hibernate.chapter02.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedContact {
	@Column
	private String recipient;
	@Column
	private String address;
	@Column
	private String phone;
	
	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
