package com.snail.springrecips.court.service;

import java.util.List;

import com.snail.springrecips.court.domain.Reservation;

public interface ReservationService {
	public List<Reservation> query(String courtName);
}
