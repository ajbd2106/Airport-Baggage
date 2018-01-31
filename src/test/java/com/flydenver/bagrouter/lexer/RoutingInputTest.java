

package com.flydenver.bagrouter.lexer;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class RoutingInputTest {

	@Test
	public void testConstructors() throws IOException {
		RoutingInput input = new RoutingInput( "/routing-input.txt" );
		assertNotNull( input );
		assertNotNull( input.getAsReader() );
		assertTrue( input.getAsReader().ready() );
		input.close();

		input = new RoutingInput( getClass().getResourceAsStream( "/routing-input.txt" ) );
		assertNotNull( input );
		assertNotNull( input.getAsReader() );
		assertTrue( input.getAsReader().ready() );
		input.close();

		input = new RoutingInput( "routing-input.txt" );
		assertNotNull( input );
		assertNotNull( input.getAsReader() );
		assertTrue( input.getAsReader().ready() );
		input.close();

		input = new RoutingInput( new StringReader( "some test string" ) );
		assertNotNull( input );
		assertNotNull( input.getAsReader() );
		assertTrue( input.getAsReader().ready() );
		input.close();
	}


	@Test( expected = IllegalArgumentException.class )
	public void testNullReader() {
		Reader r = null;
		new RoutingInput( r );
	}


	@Test( expected = IllegalArgumentException.class )
	public void testNullStream() {
		InputStream r = null;
		new RoutingInput( r );
	}


	@Test( expected = IllegalArgumentException.class )
	public void testNullString() {
		String r = null;
		new RoutingInput( r );
	}

}
