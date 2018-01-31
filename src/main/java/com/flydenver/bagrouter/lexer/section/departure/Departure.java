package com.flydenver.bagrouter.lexer.section.departure;

import com.flydenver.bagrouter.domain.Airport;
import com.flydenver.bagrouter.domain.Flight;
import com.flydenver.bagrouter.domain.TerminalGate;
import com.flydenver.bagrouter.lexer.section.SectionEntry;

import java.util.Date;

/**
 * Departure mapping as described in the departures section of the
 * routing files.
 */
public class Departure implements SectionEntry {
	private Flight flight;
	private TerminalGate flightGate;
	private Airport destination;
	private Date flightTime;


	/**
	 * Fill in the departure information from the flight details.
	 */
	public static Departure fillInFromFlightInfo( Flight flight ) {
		if ( flight == null ) {
			throw new IllegalArgumentException( "Flight information cannot be null." );
		}

		Departure departure = new Departure();
		departure.setFlight( flight );

		if ( flight.isSetDestination() ) {
			departure.setDestination( flight.getDestination() );
		}

		if ( flight.isSetFlightTime() ) {
			departure.setFlightTime( flight.getFlightTime() );
		}

		if ( flight.isSetGate() ) {
			departure.setFlightGate( flight.getGate() );
		}

		return departure;
	}

	/**
	 * Get the departing flight.
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * Set the departing flight.
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * Get the flight gate.
	 */
	public TerminalGate getFlightGate() {
		return flightGate;
	}

	/**
	 * Set the flight gate.
	 */
	public void setFlightGate(TerminalGate flightGate) {
		this.flightGate = flightGate;
	}

	/**
	 * Get the destination airport.
	 */
	public Airport getDestination() {
		return destination;
	}

	/**
	 * Set the destination airport.
	 */
	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	/**
	 * Get the departing flight time.
	 */
	public Date getFlightTime() {
		return flightTime;
	}

	/**
	 * Set the departing flight time.
	 */
	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}

}
