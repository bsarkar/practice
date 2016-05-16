package home.codility;

import java.util.ArrayList;
import java.util.List;

public class Peak {

	public int solution ( int [] arr ) {
		List<Integer> peaks = new ArrayList<Integer>() ;
		
		if ( arr.length < 3) throw new RuntimeException("Invalid)");
		for ( int i = 1 ; i < (arr.length -1) ; i++) {
			if ( arr[i] > arr[i-1] && arr[i] > arr[i+1] )
					peaks.add(i);
		}
		
		for ( int grpSize = 1 ; grpSize <= arr.length ; grpSize++) {
			if ( arr.length % grpSize != 0 ) continue ;
			
			int find = 0 ;
			int grps = arr.length/grpSize ;
			
			for ( int peakIdx : peaks) {
				if ( peakIdx/grpSize > find){
					break ;
				}
				if ( peakIdx/grpSize == find){
					find++ ;
				}
			}
			 if ( find == grps) {
				 return grps ;
			 }
		}
		return 0;
		
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 0, 1, 0, 0, 1, 0, 0, 1, 0 , 1, 0 , 1};
        int result = new Peak().solution(arr) ;
        System.out.println(result);

	}

}
