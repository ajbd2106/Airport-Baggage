

package com.flydenver.bagrouter.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class AirportTest {

	private final Airport airport1 = new Airport( "DFW" );
	private final Airport airport2 = new Airport( "JFK" );
	private final Airport airport3 = new Airport( "DFW" );

	@Test
	public void testAirportEquals() {
		assertEquals( airport1, airport3 );
		assertNotEquals( airport1, airport2 );
		assertNotEquals( airport3, airport2 );


		assertNotEquals( airport1, null );
		assertNotEquals( airport2, null );
		assertNotEquals( airport3, null );

		assertNotEquals( airport1, new TerminalGate( "DFW" ) );
		assertNotEquals( airport2, new TerminalGate( "DFW" ) );
		assertNotEquals( airport3, new TerminalGate( "DFW" ) );

		assertEquals( airport1.getId(), airport1.getAirportId() );
		assertEquals( airport2.getId(), airport2.getAirportId() );
		assertEquals( airport3.getId(), airport3.getAirportId() );

		airport1.setAirportId( "JFK" );
		assertEquals( airport1, airport2 );
		assertEquals( airport1.getId(), airport2.getAirportId() );
		assertEquals( airport2.getId(), airport2.getAirportId() );

		assertEquals( "JFK", airport1.toString() );

	}

}
