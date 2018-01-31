

package com.flydenver.bagrouter.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;


public class FlightIdTest {

	private FlightId id1 = new FlightId( "UA101" );
	private FlightId id2 = new FlightId( "FF101" );
	private FlightId id3 = new FlightId( "UA101" );


	@Test
	public void testFlightIdsEqual() {
		assertEquals   ( id1, id3 );
		assertNotEquals( id1, id2 );
		assertNotEquals( id3, id2 );

		assertNotEquals( id1, null );
		assertNotEquals( id2, null );
		assertNotEquals( id3, null );
	}


	@Test
	public void testFlightIdToString() {
		assertEquals( id1.toString(), "UA101" );
		assertEquals( id2.toString(), "FF101" );
		assertEquals( id3.toString(), "UA101" );
	}

}
