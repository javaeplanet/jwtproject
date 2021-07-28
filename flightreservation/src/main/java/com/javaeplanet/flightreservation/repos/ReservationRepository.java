package com.javaeplanet.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaeplanet.flightreservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
