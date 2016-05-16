package home.generictests;

import java.util.Arrays;

public class SortBubble {

	public int [] solution( int [] arr, String type){

		int tmp = 0 ;
		
		int inner = arr.length ;
		
		if ( type.equals("ASC")) {
			// Ascending
			for ( int i = 0 ; i < arr.length ; i++){
				for (int j = 1 ; j < inner; j++) {
					if ( arr[j] < arr[j-1]) {
						tmp = arr[j] ;
						arr[j] = arr[j-1] ;
						arr[j-1] = tmp ;			
					}
				}
				inner -= 1 ;
			}
		}
		else {

			// Descending
			inner = arr.length ;
			for ( int i = 0 ; i < arr.length ; i++){
				for (int j = 1 ; j < inner; j++) {
					if ( arr[j] > arr[j-1]) {
						tmp = arr[j] ;
						arr[j] = arr[j-1] ;
						arr[j-1] = tmp ;			
					}
				}
				inner -= 1 ;
			}
		}
		return arr ;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 1, 3 , 5, 7 , 4, 6, 9};
		System.out.println(Arrays.toString(new SortBubble().solution(arr, "ASC")));
		System.out.println(Arrays.toString(new SortBubble().solution(arr, "DSC")));

	}

}
