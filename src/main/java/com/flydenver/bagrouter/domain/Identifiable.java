
package com.flydenver.bagrouter.domain;

/**
 * Just to make sure that an object that implements this has an ID.
 */
public interface Identifiable<T> {

	/**
	 * Get this object's identifier.
	 */
	T getId();

}
