

package com.flydenver.bagrouter.routing;

import com.flydenver.bagrouter.domain.Identifiable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * Node on a graph. The node's total distance will get updated throughout the
 * node traversal process. Ultimately, this will hold the total weight.
 *
 * @param <T> Type of the node data
 */
public class Node<T> {

	private final Set<Edge<T>> edges = new HashSet<>( 10 );
	private final Object nodeId;
	private final T nodeItem;


	/**
	 * Build a node with whatever data you want.
	 */
	public Node( T nodeItem ) {
		if ( nodeItem == null ) {
			throw new IllegalArgumentException( "Null node data" );
		}

		this.nodeItem = nodeItem;
		nodeId = nodeItem instanceof Identifiable ? ((Identifiable<?>) nodeItem).getId() : nodeItem.toString();
	}

	/**
	 * Add an edge connected to this node.
	 */
	public <E extends Edge<T>> void addEdge( E edge ) {
		if ( ! edges.contains( edge ) ) {
			edges.add( edge );
		}
	}


	/**
	 * Get the attached edges.
	 */
	public Collection<Edge<T>> getEdges() {
		return edges;
	}


	/**
	 * Getter for the node identifier.
	 */
	public Object getNodeId() {
		return nodeId;
	}


	/**
	 * Getter for the node data.
	 */
	public T getNodeItem() {
		return nodeItem;
	}


	@Override
	public String toString() {
		return getNodeId() != null ?
			   getNodeId().toString() :
			   super.toString();
	}


	@Override
	public boolean equals( Object o ) {
		return o != null &&
				o instanceof Node &&
				getNodeId() != null &&
				getNodeId().equals( ((Node)o).getNodeId() );
	}

}
