
package com.flydenver.bagrouter.lexer.section;

/**
 * Section tokens identify different parts of the routing input.
 */
public enum SectionToken {

	/**
	 * Section marker for the Conveyor System.
	 */
	CONVEYOR_SYSTEM( "Conveyor System" ),
	
	/**
	 * Section marker for Departures.
	 */
	DEPARTURES( "Departures" ),
	
	/**
	 * Section marker for bag routes.
	 */
	BAGS( "Bags" ),
	
	/**
	 * Invalid token.
	 */
	UNKNOWN( "" );
	
	/**
	 * Fetch the token by the identifier.
	 * @param identifier string identifier of the token
	 * @return the token, or unknown
	 */
	public static SectionToken fromIdentifier( String identifier ) {
		if ( identifier != null && ! identifier.trim().equals("") ) {
			for ( SectionToken token : values() ) {
				if ( identifier.equalsIgnoreCase( token.getIdentifier() ) ) {
					return token;
				}
			}
		}
		
		return SectionToken.UNKNOWN;
	}
	
	//	ID string
	private final String identifier;
	public String getIdentifier() { return this.identifier; }
	SectionToken( String identifier ) { this.identifier = identifier; }

}
