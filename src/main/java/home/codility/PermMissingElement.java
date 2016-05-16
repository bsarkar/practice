package home.codility;

public class PermMissingElement {

	public long solution( int[] arr) {
		
		/*
		if ( arr == null) throw new RuntimeException("Null");
		long N = arr.length + 1 ;
		long expected = N * (N + 1) / 2 ;
		long sum = 0L ;
		for ( int i= 0 ; i < N - 1 ; i++) sum += arr[i] ;
		return (expected - sum );
		*/
		
		if ( arr == null) throw new RuntimeException("Null");
		long expected = 0 ;
		long sum = 0L ;
		int i = 0 ;
		for ( i= 0 ; i < arr.length ; i++) {
			expected += i+1 ;
			sum += arr[i] ;
		}
		expected += i+1; // missing element
		return (expected - sum );
		
	}
	public static void main(String[] args) {
		int [] arr = new int [] { 1,2,3,5 } ;
		long result = new PermMissingElement().solution(arr) ;
		System.out.println(result);

	}

}
