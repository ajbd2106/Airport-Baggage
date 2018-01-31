

package com.flydenver.bagrouter.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Domain test suite
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		AirportTest.class,
		FlightTest.class,
		FlightIdTest.class,
		TerminalGateTest.class,
		BagTest.class
})
public class DomainSuite {}
