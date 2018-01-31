

package com.flydenver.bagrouter.lexer.section.bag;

import com.flydenver.bagrouter.domain.PassengerBag;
import com.flydenver.bagrouter.lexer.ParseException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Tests for the bag route parser.
 */
public class BagEntryTest {

	private BagRowParser parser;
	private final String goodFormat = "0003 A2 UA10";
	private final String tooManyElements = "0003 A2 UA10 A3";
	private final String tooFewElements = "0003 A2";

	@Before
	public void setup() {
		parser = new BagRowParser();
	}


	//=[ good tests ]==========================================================

	
	@Test
	public void testParseGoodFormat() {
		try {
			assertNotNull( parser.parseSectionRow( goodFormat ) );
		}
		catch ( ParseException e ) {
			fail( e.getMessage() );
		}
	}

	
	//=[ bad arguments tests ]==========================================================

	
	@Test( expected = IllegalArgumentException.class )
	public void testTooManyLines() throws ParseException {
		parser.parseSectionRow( goodFormat + "\n" + goodFormat );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testTooManyLinesWindows() throws ParseException {
		parser.parseSectionRow( goodFormat + "\r\n" + goodFormat );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testNullLine() throws ParseException {
		parser.parseSectionRow( null );
	}

	
	//=[ parsing tests ]==========================================================

	
	@Test( expected = ParseException.class )
	public void testTooManyParts() throws ParseException {
		parser.parseSectionRow( tooManyElements );
	}

	@Test( expected = ParseException.class )
	public void testTooFewParts() throws ParseException {
		parser.parseSectionRow( tooFewElements );
	}

	@Test( expected = ParseException.class )
	public void testInvalidBagId() throws ParseException {
		parser.parseSectionRow( "0a03 A2 UA10" );
	}

	@Test
	public void testValidArrivalState() throws ParseException {
		BagEntry route = parser.parseSectionRow( "0003 A2 ARRIVAL" ).getWrappedRow();
		assertNotNull( route );
		assertEquals( PassengerBag.BagState.ARRIVAL, route.getBag().getBagState() );
	}

	@Test
	public void testValidInTransitState() throws ParseException {
		BagEntry route = parser.parseSectionRow( goodFormat ).getWrappedRow();
		assertNotNull( route );
		assertEquals( PassengerBag.BagState.IN_TRANSIT, route.getBag().getBagState() );
	}

}
