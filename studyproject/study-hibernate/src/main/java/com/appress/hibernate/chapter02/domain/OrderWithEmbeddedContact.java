package com.appress.hibernate.chapter02.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class OrderWithEmbeddedContact {
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	EmbeddedContact weekdayContat;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="recipient",column=@Column(name="HOLIDAY_RECIPIENT")),
		@AttributeOverride(name="address",column=@Column(name="HOLIDAY_PHONE")),
		@AttributeOverride(name="phone",column=@Column(name="HOLIDAY_ADDRESS"))
		})
	EmbeddedContact holidayContact;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EmbeddedContact getWeekdayContat() {
		return weekdayContat;
	}
	public void setWeekdayContat(EmbeddedContact weekdayContat) {
		this.weekdayContat = weekdayContat;
	}
	public EmbeddedContact getHolidayContact() {
		return holidayContact;
	}
	public void setHolidayContact(EmbeddedContact holidayContact) {
		this.holidayContact = holidayContact;
	}
	
	
}
