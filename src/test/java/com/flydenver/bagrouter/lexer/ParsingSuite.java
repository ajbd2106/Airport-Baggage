

package com.flydenver.bagrouter.lexer;

import com.flydenver.bagrouter.lexer.section.bag.BagEntryTest;
import com.flydenver.bagrouter.lexer.section.conveyor.ConveyorRouteTest;
import com.flydenver.bagrouter.lexer.section.departure.DepartureParserTest;
import com.flydenver.bagrouter.lexer.section.departure.DepartureTest;
import com.flydenver.bagrouter.lexer.section.SectionHeaderTokenizerTest;
import com.flydenver.bagrouter.lexer.section.SectionTokenTest;
import com.flydenver.bagrouter.lexer.section.SectionTypeTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite for parsing tests
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		DepartureParserTest.class,
		ConveyorRouteTest.class,
		BagEntryTest.class,
		SectionTypeTest.class,
		SectionTokenTest.class,
		DepartureTest.class,
		SectionHeaderTokenizerTest.class,
		RoutingEvaluatorTest.class
})
public class ParsingSuite {}
