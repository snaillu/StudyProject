package com.appress.hibernate.chapter04.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VideoDisc extends Disc {
	@Column
	String director;
	
	@Column
	String language;
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
