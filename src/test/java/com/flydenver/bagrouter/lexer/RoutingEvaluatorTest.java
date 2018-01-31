

package com.flydenver.bagrouter.lexer;

import static org.junit.Assert.assertNotNull;

import com.flydenver.bagrouter.domain.PassengerBag;
import com.flydenver.bagrouter.lexer.section.SectionParser;
import com.flydenver.bagrouter.lexer.section.SectionType;
import com.flydenver.bagrouter.lexer.section.bag.BagEntry;
import com.flydenver.bagrouter.lexer.section.bag.BagRowParser;
import com.flydenver.bagrouter.lexer.section.conveyor.ConveyorRoute;
import com.flydenver.bagrouter.lexer.section.conveyor.ConveyorRowParser;
import com.flydenver.bagrouter.lexer.section.departure.Departure;
import com.flydenver.bagrouter.lexer.section.departure.DepartureRowParser;
import org.junit.Test;

import java.io.InputStreamReader;


public class RoutingEvaluatorTest {


	@Test
	public void testEvaluatorInputParsing() throws ParseException {

		SectionParser parser = RoutingEvaluator.multiSectionParser( new RoutingInput( "routing-input.txt" ) );
		parser.addSectionConsumer( SectionType.BAGS, new BagRowParser(), entry -> {
			BagEntry bag = (BagEntry) entry;
			assertNotNull( bag.getBag() );
			assertNotNull( bag.getEntryPoint() );
			if (!PassengerBag.BagState.ARRIVAL.equals( bag.getBag().getBagState() )) {
				assertNotNull( bag.getFlight() );
			}
		});

		parser.addSectionConsumer( SectionType.DEPARTURES, new DepartureRowParser(), entry -> {
			Departure departure = (Departure)entry;
			assertNotNull( departure.getFlight() );
			assertNotNull( departure.getDestination() );
			assertNotNull( departure.getFlightGate() );
			assertNotNull( departure.getFlightTime() );
		});

		parser.addSectionConsumer( SectionType.CONVEYOR_SYSTEM, new ConveyorRowParser(), entry -> {
			ConveyorRoute conveyor = (ConveyorRoute)entry;
			assertNotNull( conveyor.getFirstTerminal() );
			assertNotNull( conveyor.getSecondTerminal() );
			assertNotNull( conveyor.getTravelTime() );
		});

		parser.parseSections();

	}

	@Test
	public void testEvaluatorInputReaderParsing() throws ParseException {

		InputStreamReader reader = new InputStreamReader( getClass().getResourceAsStream( "/routing-input.txt" ) );

		SectionParser parser = RoutingEvaluator.multiSectionParser( new RoutingInput( reader ) );
		parser.addSectionConsumer( SectionType.BAGS, new BagRowParser(), entry -> {
			BagEntry bag = (BagEntry) entry;
			assertNotNull( bag.getBag() );
			assertNotNull( bag.getEntryPoint() );
			if (!PassengerBag.BagState.ARRIVAL.equals( bag.getBag().getBagState() )) {
				assertNotNull( bag.getFlight() );
			}
		});

		parser.addSectionConsumer( SectionType.DEPARTURES, new DepartureRowParser(), entry -> {
			Departure departure = (Departure)entry;
			assertNotNull( departure.getFlight() );
			assertNotNull( departure.getDestination() );
			assertNotNull( departure.getFlightGate() );
			assertNotNull( departure.getFlightTime() );
		});

		parser.addSectionConsumer( SectionType.CONVEYOR_SYSTEM, new ConveyorRowParser(), entry -> {
			ConveyorRoute conveyor = (ConveyorRoute)entry;
			assertNotNull( conveyor.getFirstTerminal() );
			assertNotNull( conveyor.getSecondTerminal() );
			assertNotNull( conveyor.getTravelTime() );
		});

		parser.parseSections();

	}

	@Test
	public void testEvaluatorInputStreamParsing() throws ParseException {

		SectionParser parser = RoutingEvaluator.multiSectionParser( new RoutingInput( getClass().getResourceAsStream( "/routing-input.txt" ) ) );
		parser.addSectionConsumer( SectionType.BAGS, new BagRowParser(), entry -> {
			BagEntry bag = (BagEntry) entry;
			assertNotNull( bag.getBag() );
			assertNotNull( bag.getEntryPoint() );
			if (!PassengerBag.BagState.ARRIVAL.equals( bag.getBag().getBagState() )) {
				assertNotNull( bag.getFlight() );
			}
		});

		parser.addSectionConsumer( SectionType.DEPARTURES, new DepartureRowParser(), entry -> {
			Departure departure = (Departure)entry;
			assertNotNull( departure.getFlight() );
			assertNotNull( departure.getDestination() );
			assertNotNull( departure.getFlightGate() );
			assertNotNull( departure.getFlightTime() );
		});

		parser.addSectionConsumer( SectionType.CONVEYOR_SYSTEM, new ConveyorRowParser(), entry -> {
			ConveyorRoute conveyor = (ConveyorRoute)entry;
			assertNotNull( conveyor.getFirstTerminal() );
			assertNotNull( conveyor.getSecondTerminal() );
			assertNotNull( conveyor.getTravelTime() );
		});

		parser.parseSections();

	}


	@Test
	public void testEvaluatorInputParsingOneSection() throws ParseException {

		SectionParser parser = RoutingEvaluator.multiSectionParser( new RoutingInput( "routing-input.txt" ) );
		parser.addSectionConsumer( SectionType.BAGS, new BagRowParser(), entry -> {
			BagEntry bag = (BagEntry) entry;
			assertNotNull( bag.getBag() );
			assertNotNull( bag.getEntryPoint() );
			if (!PassengerBag.BagState.ARRIVAL.equals( bag.getBag().getBagState() )) {
				assertNotNull( bag.getFlight() );
			}
		});
		parser.parseSections();

	}

	@Test (expected =  IllegalArgumentException.class)
	public void testEvaluatorNullInput() throws ParseException {

		SectionParser parser = RoutingEvaluator.multiSectionParser( null );
		parser.addSectionConsumer( SectionType.BAGS, new BagRowParser(), entry -> {
			BagEntry bag = (BagEntry) entry;
			assertNotNull( bag.getBag() );
			assertNotNull( bag.getEntryPoint() );
			if (!PassengerBag.BagState.ARRIVAL.equals( bag.getBag().getBagState() )) {
				assertNotNull( bag.getFlight() );
			}
		});
		parser.parseSections();

	}



}
