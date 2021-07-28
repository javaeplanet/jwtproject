package com.javaeplanet.flightcheckin.integration;

import com.javaeplanet.flightcheckin.integration.dto.Reservation;
import com.javaeplanet.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
public Reservation findReservation(Long id);

public Reservation updateReservation(ReservationUpdateRequest request,  Long id);
	
}
