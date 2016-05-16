package home.generictests;

import java.util.Arrays;

public class SortSelection {

	public int[] solution( int[] arr , String type){

		int min = 0 ;
		int tmp = 0 ;

		// Ascending
		if ( type.equals("ASC"))
		{
			for ( int i = 0 ; i < arr.length ; i++){
				min = i ;
				for ( int j=i+1 ; j < arr.length; j++){
					if( arr[j] < arr[min]) {
						min = j ;
					}

				}
				tmp = arr[i] ;
				arr[i] = arr[min] ;
				arr[min] = tmp;
			}
		}
		// Descending
		else {
			tmp = 0 ;
			for ( int i = 0 ; i < arr.length ; i++){
				min = i ;
				for ( int j=i+1 ; j < arr.length; j++){
					if( arr[j] > arr[min]) {
						min = j ;
					}

				}
				tmp = arr[i] ;
				arr[i] = arr[min] ;
				arr[min] = tmp;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 5, 7 , 4, 6, 9};
		System.out.println(Arrays.toString(new SortSelection().solution(arr, "ASC")));
		System.out.println(Arrays.toString(new SortSelection().solution(arr, "DSC")));

	}

}
