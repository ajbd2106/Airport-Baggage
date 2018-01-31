
package com.flydenver.bagrouter.lexer;

import com.flydenver.bagrouter.lexer.section.SectionParser;


/**
 * Main entry point for parsing bag router files. This is just a facade for the
 * underlying {@link RoutingInput} and {@link com.flydenver.bagrouter.lexer.section.RowParsingDelegate} pieces.
 */
public class RoutingEvaluator {

	/**
	 * Create a {@link SectionParser}. This allows you to parse multiple types of section
	 * data on a single callback. The problem with the other consumes is that you must supply
	 * individual readers for each parser. This will handle closing the input.
	 *
	 * @param input {@link RoutingInput} input of routing data
	 */
	public static SectionParser multiSectionParser( RoutingInput input ) throws ParseException {
		SectionParser parser = new SectionParser( );
		parser.setSectionInput( input );
		return parser;
	}

}
