package home.generictests;

import java.util.Arrays;

public class SortInsertion {

	public void solution(int[] arr){
		
		for (int i = 1 ; i < arr.length ; i++){
			int temp = arr[i] ; // mark the item
			int j = i ;
			while ( j > 0 && arr[j -1] > temp) {
				arr[j] = arr[j-1]; // move right all items that are bigger than temp 
				// till the mark point
				--j ;
				
			}
			arr[j] = temp ;
		}
		
		System.out.println("Return :" + Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 2, 4, 5, 8, 3, 9, 7 } ;
		new SortInsertion().solution(arr);

	}

}
