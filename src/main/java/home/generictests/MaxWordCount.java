package home.generictests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class MaxWordCount {

	public int solution(String flName)	{
	BufferedReader brdr=null ;
	Map<String , Integer> wordCountMap = new HashMap<>();
	
		try {
			FileInputStream fis = new FileInputStream(flName);
			brdr = new BufferedReader(new InputStreamReader(fis))	;
			String line = null ;
			try {
				while ( (line = brdr.readLine()) != null ) {
					StringTokenizer sArr = new StringTokenizer(line," ");
					while(sArr.hasMoreTokens()) {
						String sKey = sArr.nextToken() ;
						if ( wordCountMap.get(sKey) != null) {
							wordCountMap.put(sKey, wordCountMap.get(sKey)+1) ;
						}
						else
							wordCountMap.put(sKey, 1);
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		Set<String> wSet = wordCountMap.keySet() ;
		int maxCount = 0 ;
		for ( String sKey : wSet) {
			maxCount = Math.max(maxCount, wordCountMap.get(sKey)) ;
		}
		
		return maxCount ;
		
	}
	public static void main(String[] args) {
		int wc = new MaxWordCount().solution("/Users/bish/a.txt");
		System.out.println(wc);

	}

}
