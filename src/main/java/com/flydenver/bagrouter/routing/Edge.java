

package com.flydenver.bagrouter.routing;

/**
 * General edge for a graph. Edge here is defined by the
 * connection between two nodes.
 */
public interface Edge<T> {

	/** 
	 * Getter for fist node (or starting node).
	 */
	Node<T> getFirstNode();


	/**
	 * Getter for second node (or ended node).
	 */
	Node<T> getSecondNode();


	/**
	 * Using either the first or second node, get the other node.
	 * @param thisNode from node
	 * @return other node
	 */
	Node<T> getOtherNode( Node<T> thisNode );

}
