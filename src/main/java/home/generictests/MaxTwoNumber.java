package home.generictests;

public class MaxTwoNumber {

	public int solution(int[] arr){
		int maxOne = arr[0] ;
		int maxTwo = arr[0];
		for ( int a : arr){
			if(a > maxOne) {
				maxTwo = maxOne ;
				maxOne = a ;
			}
			else if ( a > maxTwo) 
				maxTwo = a ;
		}
		System.out.println(maxOne);
		System.out.println(maxTwo);
		return 1;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 1 ,2 , 3 , 4 , 5 , 6, 7 ,8  } ;
		int result = new MaxTwoNumber().solution(arr) ;
		System.out.println(result);

	}

}
