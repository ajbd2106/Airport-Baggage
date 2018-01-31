

package com.flydenver.bagrouter.lexer.section.departure;

import com.flydenver.bagrouter.domain.Airport;
import com.flydenver.bagrouter.domain.Flight;
import com.flydenver.bagrouter.domain.FlightId;
import com.flydenver.bagrouter.domain.TerminalGate;
import com.flydenver.bagrouter.lexer.section.departure.Departure;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


/**
 * Tests for the Departure domain. Not really trying to test accessors
 * here, just testing the builder methods.
 */
public class DepartureTest {


	@Test( expected = IllegalArgumentException.class )
	public void testDepartureFromFlightNull() {
		Departure.fillInFromFlightInfo( null );
	}


	@Test
	public void testDepartureFromFlightGood() {
		Flight flight = new Flight();
		flight.setFlightId( new FlightId( "UA111" ) );
		flight.setGate( new TerminalGate( "A1" ) );
		flight.setDestination( new Airport( "DFW" ) );

		try {
			flight.setFlightTime( new SimpleDateFormat( "HH:mm" ).parse( "00:00" ) );
		}
		catch ( java.text.ParseException e ) {
			fail( e.getMessage() );
		}

		assertNotNull( Departure.fillInFromFlightInfo( flight ) );
		assertEquals( Departure.fillInFromFlightInfo( flight ).getDestination().getAirportId(), flight.getDestination().getAirportId() );
	}

}
