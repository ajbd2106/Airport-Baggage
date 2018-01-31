
package com.flydenver.bagrouter;

import com.flydenver.bagrouter.lexer.ParseException;
import com.flydenver.bagrouter.lexer.RoutingInput;
import com.flydenver.bagrouter.routing.RoutingException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


/**
 * This is just a main runner class.
 */
public class BagRouter {

	public static void main( String [] args ) {
		String inputFile = ( args.length < 1 ) ? "routing-input.txt" : args[0];

		try {
			InputStream fis1, fis2;
			File file = new File( inputFile );
			fis1 = file.exists() ? new FileInputStream( file ) : BagRouter.class.getResourceAsStream( "/" + inputFile );
			fis2 = file.exists() ? new FileInputStream( file ) : BagRouter.class.getResourceAsStream( "/" + inputFile );

			if ( fis1 == null ) {
				throw new FileNotFoundException( inputFile );
			}

			System.out.println();
			System.out.println( "[*] Dumping input " + inputFile );
			System.out.println( "[*] ------------------" );
			new RoutingInput( fis1 ).forEachLine( ( type, line ) -> System.out.println( line ) );
			System.out.println( "[*] ------------------" );

			System.out.println();
			System.out.println();
			System.out.println( "[*] Routing Table" );
			System.out.println( "[*] ------------------" );
			RoutingInput input = new RoutingInput( fis2 );
			BagRouteOutput output = new BagRouteOutput( System.out );
			RoutingEngine engine = new RoutingEngine();
			engine.executeSearch( input, output );
			System.out.println( "[*] ------------------" );

			engine.cleanup();
		}
		catch ( RoutingException | ParseException e ) {
			System.err.println( "Error routing. " + e.getMessage() );
		}
		catch ( FileNotFoundException e ) {
			System.err.println( "Could not find file. " + e.getMessage() );
		}

	}

}
