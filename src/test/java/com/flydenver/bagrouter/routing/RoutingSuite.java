

package com.flydenver.bagrouter.routing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
		DijkstraSearchStrategyTest.class,
		GraphSearchingIntegration.class,
		WeightedEdgeTest.class,
		SearchableGraphTest.class,
		SearchNodeTest.class
})
public class RoutingSuite { }
