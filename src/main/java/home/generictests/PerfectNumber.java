package home.generictests;

public class PerfectNumber {

	public boolean solution( int N ) {
		
		int store = 0 ;
		for ( int i = 1 ; i <= N/2 ; i++) {
			if ( N % i == 0 ) {
				store += i ;
			}
			
		}
		if ( store == N ) return true ;
		return false ;
	}
	public static void main(String[] args) {
		System.out.println(new PerfectNumber().solution(10));

	}

}
