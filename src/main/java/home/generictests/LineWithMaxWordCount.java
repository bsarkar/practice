package home.generictests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineWithMaxWordCount {

	public int solution() {
		int maxCnt = 0 ;

		try (FileInputStream fis = new FileInputStream("/Users/bish/a.txt") ; 
				BufferedReader brdr = new BufferedReader(new InputStreamReader(fis))){
			
			String line = null ;
			while ( (line = brdr.readLine()) != null) {
				int count = line.toLowerCase().split("\\s+").length ;
				maxCnt = Math.max(maxCnt, count) ;
			}
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxCnt ;
		

		
	}
	public static void main(String[] args) {
		System.out.println(new LineWithMaxWordCount().solution());

	}

}
