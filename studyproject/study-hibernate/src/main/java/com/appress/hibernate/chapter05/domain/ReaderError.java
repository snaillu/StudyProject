package com.appress.hibernate.chapter05.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="READERERROR")
public class ReaderError {
	@Id
	@GeneratedValue
	private Long errorID;
	
	@Column(nullable=false)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name="BOOKID")
	private Book book;
	
	
	public Long getErrorID() {
		return errorID;
	}
	public void setErrorID(Long errorID) {
		this.errorID = errorID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
