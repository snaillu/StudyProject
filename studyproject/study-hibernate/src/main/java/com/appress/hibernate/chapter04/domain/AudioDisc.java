package com.appress.hibernate.chapter04.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AudioDisc extends Disc {
	@Column
	int trackCount;
	
	@Column
	String artist;

	public int getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
}
