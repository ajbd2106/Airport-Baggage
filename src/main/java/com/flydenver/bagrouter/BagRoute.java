

package com.flydenver.bagrouter;

import com.flydenver.bagrouter.domain.PassengerBag;
import com.flydenver.bagrouter.domain.TerminalGate;
import com.flydenver.bagrouter.routing.search.NodePath;


/**
 * Bag routing for output.
 */
public class BagRoute {

	private PassengerBag bag;
	private NodePath<TerminalGate> bagPath;


	public BagRoute() { }
	public BagRoute( PassengerBag bag, NodePath<TerminalGate> bagPath ) {
		this();
		setBag( bag );
		setBagPath( bagPath );
	}


	/**
	 * Getter for the passenger's bag.
	 */
	public PassengerBag getBag() {
		return bag;
	}

	/**
	 * Setter for the passenger's bag.
	 */
	public void setBag( PassengerBag bag ) {
		this.bag = bag;
	}

	/**
	 * Getter for the {@link NodePath}
	 */
	public NodePath<TerminalGate> getBagPath() {
		return bagPath;
	}

	/**
	 * Setter for the {@link NodePath}
	 */
	public void setBagPath( NodePath<TerminalGate> bagPath ) {
		this.bagPath = bagPath;
	}

}
