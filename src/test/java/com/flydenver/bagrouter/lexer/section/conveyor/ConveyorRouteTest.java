

package com.flydenver.bagrouter.lexer.section.conveyor;

import com.flydenver.bagrouter.lexer.ParseException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

/**
 * Tests for the converyor route parsing.
 */
public class ConveyorRouteTest {

	private final String goodFormaat = "A1 A2 3";

	private ConveyorRowParser parser;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		parser = new ConveyorRowParser();
	}

	
	//=[ good tests ]==========================================================


	@Test
	public void testConveyorRouteParseGood() {
		try {
			parser.parseSectionRow(goodFormaat);
		}
		catch ( ParseException e ) {
			fail( e.getMessage() );
		}
	}


	//=[ bad argument tests ]==========================================================

	
	@Test( expected = IllegalArgumentException.class )
	public void testTooManyLines() throws ParseException {
		parser.parseSectionRow( goodFormaat + "\n" + goodFormaat );
	}

	@Test( expected = IllegalArgumentException.class )
	public void testNullLine() throws ParseException {
		parser.parseSectionRow( null );
	}

	
	//=[ parsing tests ]==========================================================
	

	@Test( expected = NumberFormatException.class )
	public void testInvalidFlightTime() throws ParseException {
		parser.parseSectionRow( "A1 A2 " + Long.toString( (long) Integer.MAX_VALUE + 1000l ) );
	}

	@Test
	public void testTooManyParts() throws ParseException {
		String tooManyParts = goodFormaat + " 99";
		exception.expect( ParseException.class );
		exception.expectMessage( "Conveyor route line doesn't match pattern ^(\\w+\\s+)(\\w+\\s+)(\\d+)$" );
		parser.parseSectionRow( tooManyParts );
	}

	@Test
	public void testTooFewParts() throws ParseException {
		exception.expect( ParseException.class );
		exception.expectMessage( "Conveyor route line doesn't match pattern ^(\\w+\\s+)(\\w+\\s+)(\\d+)$" );
		parser.parseSectionRow( "A1 A2" );
	}

}
