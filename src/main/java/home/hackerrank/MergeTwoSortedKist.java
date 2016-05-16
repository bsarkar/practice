package home.hackerrank;

import java.util.Arrays;

public class MergeTwoSortedKist {

	public int [] solution(int[] A , int [] B){
		
		int i = A.length - 1 ;
		int j = B.length - 1 ;
		int K = A.length + B.length ;
		int [] ret = new int[K];
		
		while(--K >= 0) {
			if ((j <0 ) || ( i >= 0  && A[i] >= B[j]) ){
				ret[K] = A[i--];
			}
			else {
				ret[K] = B[j--] ;
			}
		}
		return ret ;
	}
	public static void main(String[] args) {
		int [] arr1 = new int[] { 1, 3 , 5 , 7 , 9 };
		int [] arr2 = new int[] { 2 , 4 , 6, 8  };
		
		int [] ret = new MergeTwoSortedKist().solution( arr1 , arr2);
		System.out.println(Arrays.toString(ret));
		

	}

}
