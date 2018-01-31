

package com.flydenver.bagrouter.routing;

/**
 * General routing exception
 */
public class RoutingException extends Exception {
	private final static long serialVersionUID = 1l;

	public RoutingException( String message ) { super(message); }
	public RoutingException( String message, Throwable t ) { super(message, t); }

}
