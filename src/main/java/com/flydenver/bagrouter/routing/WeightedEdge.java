

package com.flydenver.bagrouter.routing;

/**
 * {@link Edge} implementation for {@link Edge}s with weights.
 * @param <T> Type of {@link Node} data that the {@link Edge} contains.
 */
public class WeightedEdge<T> implements Edge<T>, Comparable<WeightedEdge<T>> {
	private final Node<T> firstNode;
	private final Node<T> secondNode;
	private final int weight;


	/**
	 * Construct an edge as a line between two nodes. This will automatically
	 * add this edge to the nodes so the nodes are aware of the edge that
	 * connects them.
	 */
	public WeightedEdge( Node<T> firstNode, Node<T> secondNode, int weight ) {
		if ( weight < 0 ) { throw new IllegalArgumentException( "Weight must not be negative" ); }
		if ( firstNode == null || secondNode == null || firstNode == secondNode || firstNode.equals( secondNode ) ) {
			throw new IllegalArgumentException( "Nodes must not be null or equal" );
		}

		this.weight = weight;
		
		this.firstNode = firstNode;
		this.firstNode.addEdge( this );

		this.secondNode = secondNode;
		this.secondNode.addEdge( this );
	}


	/** Edge's weight */
	public int getWeight() {
		return weight;
	}


	@Override
	public Node<T> getFirstNode() {
		return firstNode;
	}


	@Override
	public Node<T> getSecondNode() {
		return secondNode;
	}


	@Override
	public Node<T> getOtherNode( Node<T> thisNode ) {
		return getFirstNode().equals( thisNode ) ? getSecondNode() : getFirstNode();
	}


	@Override
	public String toString() {
		return "[" + getFirstNode() + "-" + getSecondNode() + " {" + getWeight() + "}]";
	}


	@Override
	@SuppressWarnings( "unchecked" )
	public boolean equals( Object obj ) {
		return obj != null &&
				obj instanceof Edge &&
				getFirstNode () != null &&
				getSecondNode() != null &&
				((getFirstNode().equals( ((Edge<T>) obj).getFirstNode() ) &&
				getSecondNode().equals( ((Edge<T>) obj).getSecondNode())) ||
				(getFirstNode().equals( ((Edge<T>) obj).getSecondNode() ) &&
				getSecondNode().equals( ((Edge<T>) obj).getFirstNode()) ));
	}


	@Override
	public int compareTo( WeightedEdge<T> o ) {
		return Integer.compare( getWeight(), o.getWeight() );
	}

}
