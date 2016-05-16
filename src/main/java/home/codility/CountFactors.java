package home.codility;

/*
 We incremente the count by two because based on one divisor, we can find the symmetric divisor.
  In other words, if a is a divisor of n then n/a is also one. The only case when that does not
  happen is when is if the number is in the form k^2, meaning that the symmetric divisor of k 
  is also k.
 */

public class CountFactors {

	public int solution ( int N) {
		int cnt = 0 ;
		int i = 1 ;
		while ( i * i <= N){
			if ( N % i == 0)
				if ( i * i == N)
					cnt += 1;
				else 
				cnt += 2 ;
			i++ ;
		}
		return cnt ;
	}
	public static void main(String[] args) {
		int result = new CountFactors().solution(8)	;
		System.out.println(result);

	}

}
