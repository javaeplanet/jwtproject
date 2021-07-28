package com.javaeplanet.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.javaeplanet.flightcheckin.integration.dto.Reservation;
import com.javaeplanet.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_SINGLE_RESERVATION = "http://localhost:8080/flightreservation/reservations/";
	private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/currentreservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate=new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_SINGLE_RESERVATION+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request, Long id) {
		RestTemplate restTemplate=new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL+id, request, Reservation.class);
		return reservation;
	}

}
