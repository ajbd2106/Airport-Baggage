package com.flydenver.bagrouter;

import com.flydenver.bagrouter.routing.search.SearchRouteException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;


/**
 * Class for writing out the bag path.
 */
public class BagRouteOutput {

	private final static String NEWLINE = System.getProperty( "line.separator" );
	private final Writer writer;


	/** Construct an output using the given writer. */
	public BagRouteOutput( Writer output ) {
		if ( output == null ) {
			throw new IllegalArgumentException( "Null writer" );
		}
		this.writer = output;
	}


	/** Construct an output using the given stream. */
	public BagRouteOutput( OutputStream output ) {
		if ( output == null ) {
			throw new IllegalArgumentException( "Null writer" );
		}
		this.writer = new OutputStreamWriter( output );
	}


	/**
	 * Close the route output.
	 */
	public void close() throws IOException {
		writer.close();
	}


	/**
	 * Close the route output ignoring any errors
	 * @return true if the output succeeds, false otherwise
	 */
	public boolean closeQuietly() {
		boolean ret = false;
		try {
			close();
			ret = true;
		}
		catch ( IOException e ) { /* ignore failure */ }
		return ret;
	}


	/**
	 * Write a single {@link BagRoute} to the output.
	 * @param route single {@link BagRoute} entry
	 */
	public void write( BagRoute route ) throws IOException {
		if ( route == null || route.getBag() == null || route.getBagPath() == null ) {
			throw new IllegalArgumentException( "Null route data." );
		}

		final Writer writer = getWriter();
		try {
			writer.write( route.getBag().getBagNumber() );
			writer.write( " " );

			route.getBagPath().forEachNode( gate -> {
				writer.write( gate.getGateNumber() );
				writer.write( " " );
			});

			writer.write( ": " );
			writer.write( String.valueOf( route.getBagPath().getTotalDistance() ) );

		}
		catch ( SearchRouteException | RuntimeException e ) {
			throw new IOException( "Error writing bag route.", e );
		}
	}


	/**
	 * Same as {@link #write(BagRoute)}, but a line separator is added.
	 */
	public void writeln( BagRoute route ) throws IOException {
		write( route );
		getWriter().write( NEWLINE );
	}


	/**
	 * Flush the output.
	 */
	public void flush() throws IOException {
		getWriter().flush();
	}


	protected Writer getWriter() {
		return writer;
	}

}
