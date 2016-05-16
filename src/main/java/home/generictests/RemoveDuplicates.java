package home.generictests;

import java.util.Arrays;

public class RemoveDuplicates {

	public int [] solution( int [] arr){
		int i = 0 ;
		int j = 1 ;
		while ( j < arr.length){
			if( arr[j] == arr[i])
				j++ ;
			else {
				arr[++i] = arr[j++] ; // Note ++i and j++
			}
		}
		int [] ret = new int[i+1] ;
		for ( int k = 0 ; k < i+1 ; k++) {
			ret[k] = arr[k] ;
		}
		return ret ;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 1, 2 , 4 , 4 , 5 , 6 } ;
		int [] ret = new RemoveDuplicates().solution(arr) ;
		System.out.println(Arrays.toString(ret));
	}

}
