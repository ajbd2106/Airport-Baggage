
package com.flydenver.bagrouter.lexer.section;

/**
 * This is just a generic wrapper for a row of a given type specified by {@code T}.
 */
public class SectionRowWrapper<T extends SectionEntry> {

	private T wrappedRow;

	public SectionRowWrapper( T wrappedRow ) {
		setWrappedRow( wrappedRow );
	}

	/**
	 * Get the wrapped row data
	 */
	public T getWrappedRow() {
		return this.wrappedRow;
	}

	/**
	 * Wrap the row data.
	 */
	public void setWrappedRow( T wrappedRow ) {
		this.wrappedRow = wrappedRow;
	}

}
