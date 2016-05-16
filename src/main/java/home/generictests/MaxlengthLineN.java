package home.generictests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MaxlengthLineN {
	
	public static class Entry {
		private int len ;
		private String line ;
		
		public Entry(int inLen, String inLine) {
			this.len = inLen ;
			this.line = inLine ;
		}
		
		public int getLen() {
			return len ;
		}
		
		public String getLine() {
			return line ;
		}
	}
	
	public static class MyComp implements Comparator {
		public int compare( Object o1 , Object o2) {
			if ( ((Entry) o2).getLen() == ((Entry)o1).getLen())
				return 0 ;
			if( ((Entry) o2).getLen() > ((Entry) o1).getLen())
					return 1;
			else
				return -1 ;
		}

	}
	public void solution(String flName , int N){
		
		try ( FileReader fis = new FileReader(new File(flName)) ;
				BufferedReader brdr = new BufferedReader(fis)) {
			String line = null ;
			Set<Entry> inpSet = new TreeSet<>( new MyComp()) ;
			int maxNLines = N ;
			while ( (line = brdr.readLine()) != null) {
				int len = line.length() ;
				Entry en = new Entry(len , line) ;
				inpSet.add(en) ;			
			}
			int cnt = -1 ;
			for ( Entry en : inpSet) {
				if( ++cnt == maxNLines)
					break ;
				else
					System.out.println(en.getLine());
			}
		} catch( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new MaxlengthLineN().solution("/Users/bish/b.txt", 2);

	}

}
