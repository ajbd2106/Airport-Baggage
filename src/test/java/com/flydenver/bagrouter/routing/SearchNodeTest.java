

package com.flydenver.bagrouter.routing;


import com.flydenver.bagrouter.routing.search.SearchNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class SearchNodeTest {

	private Node<String> node1 = new Node<>( "A1" );
	private Node<String> node2 = new Node<>( "A2" );
	private Node<String> node3 = new Node<>( "A1" );

	@Test (expected = IllegalArgumentException.class)
	public void testNullSearchNode() {
		new SearchNode<>( null );
	}

	@Test
	public void testSearchNode() {
		Node<String> snode1 = new SearchNode<>( node1 );
		Node<String> snode2 = new SearchNode<>( node2 );
		Node<String> snode3 = new SearchNode<>( node3 );

		assertEquals( node1, node3 );
		assertEquals( node1, snode1 );
		assertEquals( node1, snode3 );
		assertEquals( node3, snode1 );
		assertEquals( node3, snode3 );
		assertEquals( snode1, snode3 );
		assertEquals( snode1, snode1 );

		assertEquals( node1, ((SearchNode)snode1).getNode() );
		assertTrue( node1 == ((SearchNode) snode1).getNode() );

		assertNotEquals( node1, node2 );
		assertNotEquals( node1, snode2 );
		assertNotEquals( snode1, snode2 );

	}

	@Test
	public void testSearchNodeDistance() {
		SearchNode<String> snode1 = new SearchNode<>( node1 );
		SearchNode<String> snode2 = new SearchNode<>( node2 );

		snode1.setDistance( 4 );
		snode2.setDistance( 2 );

		assertEquals( snode1.compareTo( snode2 ), 1 );
		assertEquals( snode2.compareTo( snode1 ), -1 );
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSearchNodeNullDistance() {
		new SearchNode<>( node1 ).setDistance( -2 );
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSearchNodeNullCompare() {
		new SearchNode<>( node1 ).compareTo( null );
	}

}
