

package com.flydenver.bagrouter;


import com.flydenver.bagrouter.domain.DomainSuite;
import com.flydenver.bagrouter.lexer.ParsingSuite;
import com.flydenver.bagrouter.routing.RoutingSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Full test suite for the bagrouter project.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		ParsingSuite.class,
		DomainSuite.class,
		RoutingSuite.class,
		BagRouteOutputTest.class,
		RoutingEngineTest.class
})
public class FullSuite {}
