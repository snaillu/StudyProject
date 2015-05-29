package com.appress.hibernate.chapter02.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	private Long department;
	private Long idCard;
	private String name;
	
	public Employee(Long department,Long idCard,String name){
		this.department = department;
		this.idCard = idCard;
		this.name = name;
	}
	
	public Employee(){}
	
	@Id
	public Long getDepartment() {
		return department;
	}
	public void setDepartment(Long department) {
		this.department = department;
	}
	@Id
	public Long getIdCard() {
		return idCard;
	}
	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}
	
	@Column(unique=true,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
