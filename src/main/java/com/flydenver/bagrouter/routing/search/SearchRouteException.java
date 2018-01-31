

package com.flydenver.bagrouter.routing.search;

import com.flydenver.bagrouter.routing.RoutingException;


/**
 * General search routing exceptions
 */
public class SearchRouteException extends RoutingException {
	private final static long serialVersionUID = 1l;

	public SearchRouteException( String message ) { super(message); }
	public SearchRouteException( String message, Throwable t ) { super(message, t); }
}
