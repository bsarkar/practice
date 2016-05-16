package home.codility;

public class MaxDoubleSliceSum {

	public int soulution ( int [] arr) {
		
		int len = arr.length ;
		int [] endArr = new int [len] ;
		int [] startArr = new int [len];
		
		// ending in i th element
		for ( int i = 1 ; i < len-1 ; i++) {
			endArr[i] = Math.max((endArr[i-1] + arr[i]), 0);
		}
		
		// starting at ith element
		for ( int i = len-2 ; i > 0 ; i--) {
			startArr[i] = Math.max((startArr[i+1] + arr[i]), 0);
		}
		 
		int max = 0 ;
		
		for ( int i = 1 ; i < len-1 ; i++) {
			max = Math.max((endArr[i-1] + startArr[i+1]), max) ;
		}
		
		return max ;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 5 , -7 , 3 , 5 , -2 , 4 , -1 };
		arr = new int[] { 5  };
        int result = new MaxSliceSum().solution(arr) ;
        System.out.println(result);
	}

}
