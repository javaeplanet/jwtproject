package com.javaeplanet.flightreservation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaeplanet.flightreservation.dto.ReservationRequest;
import com.javaeplanet.flightreservation.entity.Flight;
import com.javaeplanet.flightreservation.entity.Passenger;
import com.javaeplanet.flightreservation.entity.Reservation;
import com.javaeplanet.flightreservation.repos.FlightRepository;
import com.javaeplanet.flightreservation.repos.PassengerRepository;
import com.javaeplanet.flightreservation.repos.ReservationRepository;
import com.javaeplanet.flightreservation.util.EmailUtil;
import com.javaeplanet.flightreservation.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	PdfGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("inside bookFlight()");
		Long flightId = request.getFlightId();
		LOGGER.info("fetching flight for flight id:" + flightId);
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("saving the passenger:" + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("saving the reservation:" + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		String filePath = "\\C:\\Users\\SPIN\\reservation" + savedReservation.getId() + ".pdf";
		LOGGER.info("Generating the Itinerary");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("Emailing the Itinerary:");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;
	}

}
