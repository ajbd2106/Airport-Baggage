
package com.flydenver.bagrouter.lexer.section;

import com.flydenver.bagrouter.lexer.ParseException;


/**
 * Strategy for parsing individual section rows.
 */
public interface RowParsingDelegate<T extends SectionEntry> {

	/**
	 * Parse a single line, returning a parsed section node.
	 *
	 * @param sectionLine one line from the given section type.
	 * @return the parsed section entry as wrapped type {@code T}
	 * @throws ParseException if the line couldn't be parsed
	 */
	SectionRowWrapper<T> parseSectionRow( String sectionLine ) throws ParseException;

}
