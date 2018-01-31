

package com.flydenver.bagrouter.domain;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class TerminalGateTest {

	private TerminalGate gate1 = new TerminalGate( "A1" );
	private TerminalGate gate2 = new TerminalGate( "A2" );
	private TerminalGate gate3 = new TerminalGate( "A1" );

	@Test
	public void testGatesEqual() {
		assertEquals( gate1, gate3 );
		assertNotEquals( gate1, gate2 );
		assertNotEquals( gate3, gate2 );

		assertNotEquals( gate1, null );
		assertNotEquals( gate2, null );
		assertNotEquals( gate3, null );

		assertEquals( gate1.toString(), "A1" );
	}

}
