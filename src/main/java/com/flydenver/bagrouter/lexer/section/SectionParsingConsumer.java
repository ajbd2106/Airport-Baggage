
package com.flydenver.bagrouter.lexer.section;

import com.flydenver.bagrouter.lexer.ParseException;


/**
 * Section consumer for generic section entries.
 * @param <T> type of data being consumed.
 */
public interface SectionParsingConsumer<T extends SectionEntry> {

	/**
	 * Callback for a section row.
	 * @param data section row data.
	 * @throws ParseException
	 */
	void accept( T data ) throws ParseException;

}
