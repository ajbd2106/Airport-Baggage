

package com.flydenver.bagrouter.domain;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class BagTest {

	private final PassengerBag bag1 = new PassengerBag( "001" );
	private final PassengerBag bag2 = new PassengerBag( "002" );
	private final PassengerBag bag3 = new PassengerBag( "003" );
	private final PassengerBag bag4 = new PassengerBag( "001" );

	@Test
	public void testBagsEqual() {
		assertEquals( bag1, bag4 );
		assertNotEquals( bag1, bag2 );
		assertNotEquals( bag1, bag3 );
		assertNotEquals( bag2, bag3 );
		assertNotEquals( bag2, bag4 );
		assertNotEquals( bag4, bag3 );

		assertNotEquals( bag1, null );
		assertNotEquals( bag2, null );
		assertNotEquals( bag3, null );
		assertNotEquals( bag4, null );

		assertEquals( "001", bag1.toString() );
	}

}
