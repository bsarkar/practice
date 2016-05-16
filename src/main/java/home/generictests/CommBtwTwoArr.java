package home.generictests;

import java.util.Arrays;

public class CommBtwTwoArr {
	
	public int [] solution(int [] A , int [] B) {
		int aLen = A.length ;
		int bLen = B.length ;
		int cLen = aLen + bLen ;
		
		int[] ret = new int[cLen] ;
		int k = 0 ;
		int i = 0 ;
		int j = 0 ;
		while ( --cLen > 0){
			if ( i >= aLen || j >= bLen) break ;
				if ( A[i] == B[j])
					ret[k++] = A[i] ;
				if( A[i] > B[j])
						j++ ;
				else
					i++ ;
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2 , 4, 5 , 6, 7};
		int[] arr2 = new int[] {  4, 5 , 9 , 10 };

		int [] ret = new CommBtwTwoArr().solution(arr1, arr2) ;
		System.out.println(Arrays.toString(ret));
	}

}
