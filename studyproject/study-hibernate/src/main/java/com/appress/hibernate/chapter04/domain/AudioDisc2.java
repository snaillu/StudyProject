package com.appress.hibernate.chapter04.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.InheritanceType;

@Entity
public class AudioDisc2 extends Disc2 {
	@Column
	int trackCount;
	
	@Column
	String artist;
}
