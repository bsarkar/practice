package home.codility;

import java.util.Arrays;

public class Triangle {

	public int solution( int [] arr) {
		
		if ( arr == null || arr.length < 3 ) throw new RuntimeException("Invalid data");
		Arrays.sort(arr);
		// Now all we need to do is arr[i] + arr[i+1] > arr[i+2] ;
		for ( int i = 0 ; i < arr.length - 2; i++){
			if ( arr[i] + arr[i+1] > arr[i+2])
				return 1 ;
		}
		return 0 ;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 2 , 4 , 3 };
        int result = new Triangle().solution(arr) ;
        System.out.println(result);
	}

}
