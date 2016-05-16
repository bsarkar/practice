package home.generictests;

public class FindMiddleIndx {

	public int solution(int [] arr) {
		long left = 0;
		long right = 0 ;
		for (int a : arr) {
			right += a ;
		}
		
		for ( int i = 0 ; i < arr.length ; i++) {
			left += arr[i] ;
			right -= arr[i] ;
			if ( left == right)	 return i;
		
		}
		return -1 ;		
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 2 , 4 , 4 , 5 , 4 , 1 } ;
		int result = new FindMiddleIndx().solution(arr) ;
		System.out.println(result);

	}

}
