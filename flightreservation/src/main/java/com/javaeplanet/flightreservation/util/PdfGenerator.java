package com.javaeplanet.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.javaeplanet.flightreservation.entity.Reservation;

@Component
public class PdfGenerator {
	private static final Logger LOGGER=LoggerFactory.getLogger(PdfGenerator.class);
	public void generateItinerary(Reservation reservation, String filePath) {
		LOGGER.info("generateItinerary()");
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(generateTable(reservation));

			document.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("Exception in generating Itinerary"+e);
		} catch (DocumentException e) {
			LOGGER.error("Exception in generating Itinerary"+e);
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Airlines");
		table.addCell(reservation.getFlight().getOperatingAirlines());

		table.addCell("departure city");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("arrival city");
		table.addCell(reservation.getFlight().getArrivalCity());

		table.addCell("flight number");
		table.addCell(reservation.getFlight().getFlightNumber());
		table.addCell("departure date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		table.addCell("departure time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

		cell = new PdfPCell(new Phrase("Passenger details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("first name");
		table.addCell(reservation.getPassenger().getFirstName());

		table.addCell("last name");
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell("email");
		table.addCell(reservation.getPassenger().getEmail());

		table.addCell("phone");
		table.addCell(reservation.getPassenger().getPhone());

		return table;
	}
}
