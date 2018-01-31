

package com.flydenver.bagrouter;

import com.flydenver.bagrouter.lexer.RoutingInput;
import com.flydenver.bagrouter.routing.RoutingException;
import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;


/**
 * Integration tests for the {@link RoutingEngine}
 */
public class RoutingEngineTest {

	private StringBuilder sampleOutput;


	@Before
	public void setup() {
		sampleOutput = new StringBuilder( 500 );
		sampleOutput.append( "0001 Concourse_A_Ticketing A5 A1 : 11\n" );
		sampleOutput.append( "0002 A5 A1 A2 A3 A4 : 9\n" );
		sampleOutput.append( "0003 A2 A1 : 1\n" );
		sampleOutput.append( "0004 A8 A9 A10 A5 : 6\n" );
		sampleOutput.append( "0005 A7 A8 A9 A10 A5 BaggageClaim : 12\n" );
	}


	@Test
	public void testExecute() throws RoutingException {
		StringWriter sw = new StringWriter(  );
		RoutingInput input = new RoutingInput( "routing-input.txt" );
		BagRouteOutput output = new BagRouteOutput( sw );
		RoutingEngine engine = new RoutingEngine();
		engine.setBaggageClaimId( "BaggageClaim" );
		engine.executeSearch( input, output );
		engine.cleanup();

		assertEquals( sampleOutput.toString(), sw.toString() );
	}

}
