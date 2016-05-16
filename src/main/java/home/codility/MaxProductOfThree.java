package home.codility;

import java.util.Arrays;

public class MaxProductOfThree {

	public int solution( int [] arr) {
		
		if ( arr.length < 3 || arr == null) throw new RuntimeException("Invalid data");
		
		Arrays.sort(arr);
		
		// only two possibilities
		//  int[] input = { -3, 1, 2, -2, 5, 6 };
		int len = arr.length ;
		int prd1 = arr[len-1] * arr [ len -2] * arr [ len - 3] ; 
		int prd2 = arr[0] * arr [ 1] * arr [ len - 1] ; // first two are negative after sort
		
		return Math.max(prd1, prd2);
	}
	public static void main(String[] args) {
		 int [] arr = new int[] { -3, 1, 2, -2, 5, 6 };;
	        int result = new MaxProductOfThree().solution(arr);
	        System.out.println(result) ;

	}

}
