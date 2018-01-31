

package com.flydenver.bagrouter.routing;


/**
 * Implementation of {@link Graph} that uses weighted {@link Edge}s.
 */
public class WeightedGraph<T> extends Graph<T, WeightedEdge<T>> {

	/**
	 * Add an edge to the graph derived from the two nodes, and the assigned weight.
	 */
	public void addEdge( Node<T> firstNode, Node<T> secondNode, int weight ) {
		if ( firstNode == null || secondNode == null ) {
			throw new IllegalArgumentException( "Null nodes." );
		}

		if ( ! nodes().containsKey( firstNode.getNodeId() ) ) {
			nodes().put( firstNode.getNodeId(), firstNode );
		}

		if ( ! nodes().containsKey( secondNode.getNodeId() ) ) {
			nodes().put( secondNode.getNodeId(), secondNode );
		}

		Node<T> first  = nodes().get( firstNode.getNodeId() );
		Node<T> second = nodes().get( secondNode.getNodeId() );
		WeightedEdge<T> edge = new WeightedEdge<>( first, second, weight );

		first.addEdge( edge );
		second.addEdge( edge );

		if ( ! edges().contains( edge ) ) {
			edges().add( edge );
		}

		addNodesFromEdge( edge );

	}

}
