package com.javaeplanet.flightreservation.service;

import com.javaeplanet.flightreservation.dto.ReservationRequest;
import com.javaeplanet.flightreservation.entity.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
