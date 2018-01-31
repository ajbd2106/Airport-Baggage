
package com.flydenver.bagrouter.lexer;

/**
 * Generic routing file paring exceptions.
 */
public class ParseException extends Exception {
	private final static long serialVersionUID = 1l;

	public ParseException( String message ) { super( message ); }
	public ParseException( String message, Throwable t ) { super( message, t ); }

}
