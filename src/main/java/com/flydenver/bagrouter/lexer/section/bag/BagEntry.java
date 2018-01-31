
package com.flydenver.bagrouter.lexer.section.bag;

import com.flydenver.bagrouter.domain.Flight;
import com.flydenver.bagrouter.domain.PassengerBag;
import com.flydenver.bagrouter.domain.TerminalGate;
import com.flydenver.bagrouter.lexer.section.SectionEntry;

/**
 * Bag route mapping described in the bag list section for the
 * route input files.
 */
public class BagEntry implements SectionEntry {
	private PassengerBag bag;
	private TerminalGate entryPoint;
	private Flight flight;

	/**
	 * Get the bag.
	 */
	public PassengerBag getBag() {
		return bag;
	}

	/**
	 * Set the bag.
	 */
	public void setBag(PassengerBag bag) {
		this.bag = bag;
	}

	/**
	 * Get the entry point for the bag.
	 */
	public TerminalGate getEntryPoint() {
		return entryPoint;
	}

	/**
	 * Set the entry gate for the bag.
	 */
	public void setEntryPoint(TerminalGate entryPoint) {
		this.entryPoint = entryPoint;
	}

	/**
	 * Get the bag's flight.
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * Set the flight the bag is on.
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
