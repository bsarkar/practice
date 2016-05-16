package home.codility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test1 {

	private Reader rdr ;
	private BufferedReader brdr ;
	
	private LineIterator lIter ;
	
	Test1( Reader r) {
		rdr = r ;
	}
	
	public Iterator getIterator() {
		if ( lIter == null)	{
			lIter = new LineIterator(rdr);		
			return lIter ;
		}
		else
			return lIter ;
	}
	
	public class LineIterator implements Iterator<String> {
		private String cacheBuf ;
		private boolean finished = false ;
		char [] cArr = new char[255];
		
		public LineIterator( final Reader rdr)	{
			if ( rdr == null ) 
					throw new IllegalArgumentException("Reader shouldn't be null");
			if ( rdr instanceof BufferedReader) {
				brdr = (BufferedReader)rdr ;
			}
			else {
				brdr = new BufferedReader(rdr) ;
			}
		}
		
		public boolean hasNext() {
			if( cacheBuf != null) 
				return true ;
			if ( finished) {
				return false ;
			}
			else {
				try {
					while(true) {
						String line = brdr.readLine();
						if ( line == null){
							finished = true ;
							return false ;
						}
						else {
							line = line.trim();
							try {
								Integer.parseInt(line);
							} catch ( NumberFormatException e) {
								System.out.println("Not an Integer") ;
								cacheBuf=null ;
//								next() ;
								 return true ;
							}
//							 cArr = line.toCharArray();
//							 StringBuffer tmpLine = new StringBuffer(255);
//							 for ( char i : cArr) {
//								 if ( i >= '0' && i <= '9') {
//									 tmpLine.append(i) ;
//								 }
//								 else {
//									 
//									 next() ;
//								 }
//							 }
							cacheBuf = line ;
							return true ;
						}
					}
				} catch ( final IOException ioe){
					try {
						close();
					} catch ( Exception e) {
						throw new IllegalStateException(ioe);
					}
				throw new IllegalStateException(ioe);
				}
			}
		
		}
		public String nextLine() {
			if (!hasNext()) {
				System.out.println("No more data");
//				throw new NoSuchElementException("No data") ;
				return null ;
			}
			final String currentLine = cacheBuf ;
			cacheBuf = null ;
			return currentLine ;
		}
		
		public void close() throws IOException {
			finished = true ;
			brdr.close();
			cacheBuf = null ;			
		}
		
		public  void closeQuitely(final LineIterator iterator) throws IOException {
			if ( iterator != null)
					iterator.close();
					
		}

		public String next() {
			return nextLine() ;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader tbrd = new BufferedReader(new FileReader("/Users/bish/abc"));
		Test1 t = new Test1(tbrd) ;
		Iterator it = (LineIterator)t.getIterator() ;
		String ret ;
		while (  it.hasNext() ) {	
			ret = (String) it.next() ;
			if(ret != null) {
				System.out.println(ret);
			}
		}
	}
}
