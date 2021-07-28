package com.javaeplanet.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaeplanet.flightreservation.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
