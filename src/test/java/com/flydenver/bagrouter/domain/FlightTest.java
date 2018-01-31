

package com.flydenver.bagrouter.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class FlightTest {
	private Flight flight1;
	private Flight flight2;
	private Flight flight3;

	@Before
	public void setup() {
		flight1 = new Flight( new FlightId( "UA101" ) );
		flight1.setGate( new TerminalGate( "A1" ) );
		flight1.setDestination( new Airport( "DFW" ) );

		flight2 = new Flight( new FlightId( "FF101" ) );
		flight2.setGate( new TerminalGate( "A1" ) );
		flight2.setDestination( new Airport( "JFK" ) );

		flight3 = new Flight( );
		flight3.setFlightId( new FlightId( "UA101" ) );
		flight3.setGate( new TerminalGate( "A1" ) );
		flight3.setDestination( new Airport( "DFW" ) );
	}

	@Test
	public void testFlightEquals() {
		assertEquals( flight1, flight3 );
		assertNotEquals( flight1, flight2 );
		assertNotEquals( flight3, flight2 );

		assertNotEquals( flight1, null );
		assertNotEquals( flight2, null );
		assertNotEquals( flight3, null );
		assertNotEquals( flight3, null );

		assertEquals( flight1.toString(), "UA101" );
	}

}
