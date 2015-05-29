package com.snail.spring.ch09.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="contact")
public class Contact implements Serializable {
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private Date birDate;
	private Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();
	private Set<Hobby> hobbies = new HashSet<Hobby>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Version
	@Column(name="VERSION")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	public Date getBirDate() {
		return birDate;
	}
	public void setBirDate(Date birDate) {
		this.birDate = birDate;
	}
	
	@OneToMany(mappedBy="contact",cascade=CascadeType.ALL,orphanRemoval=true)
	public Set<ContactTelDetail> getContactTelDetails() {
		return contactTelDetails;
	}
	public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
		this.contactTelDetails = contactTelDetails;
	}
	
	@ManyToMany
	@JoinTable(name="contact_hobby_detail",joinColumns=@JoinColumn(name="CONTACT_ID"),
			inverseJoinColumns=@JoinColumn(name="HOBBY_ID"))
	public Set<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", version=" + version + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birDate=" + birDate
				+ "]";
	}
	
}
