

package com.flydenver.bagrouter.routing.search;

import com.flydenver.bagrouter.routing.Edge;
import com.flydenver.bagrouter.routing.Graph;
import com.flydenver.bagrouter.routing.Node;


/**
 * Describes a strategy for searching a graph.
 */
public interface GraphSearchStrategy<T, G extends Graph<T, ? extends Edge<T>>> {

	/**
	 * Search the given {@link Graph} for the "optimal" path from the first
	 * {@link Node} to the second {@link Node}. It is up to the implantation of
	 * the strategy to determine what is meant by "optimal"
	 *
	 * @param graph     {@link Graph} to search
	 * @param startNode starting {@link Node}
	 * @param endNode   {@link Node} to search for
	 * @return the node path starting with startNode, and ending with endNode.
	 */
	NodePath<T> findPath( G graph, Node<T> startNode, Node<T> endNode );

}
