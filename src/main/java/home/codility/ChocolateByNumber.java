package home.codility;

public class ChocolateByNumber {

	// @nd Solution
	
			// Solution is LCM ( N, M) / M
			// LCM ( N , M ) = N * M / gcd ( N, M )
			// Solution = N* M / gcd( N , M ) * 1/M
			//          = N / gcd (N , M)
			
	private int gcd( int a , int b) {
				if ( a % b == 0)
					return b ;
				else {
					return gcd ( b , a % b);
				}
			}
			
	public int solution( int totChoc , int incr)	{
		/*
		int [] totStatus = new int [totChoc];
		
		for ( int i = 0 ; i < totChoc  ; i++)	{
			totStatus[i] = -1 ;
		}
		
		int i = 0 ;
		int cnt = 0 ;
		while ( totStatus[i] == -1 ) {
			totStatus[i] = 0 ;
			cnt += 1;
			i = (i+ incr) % (totChoc);

		}
		
		return cnt;
		*/
		
		return totChoc / gcd (totChoc , incr);
	}
	public static void main(String[] args) {
		
        int result = new ChocolateByNumber().solution(13, 3) ;
        System.out.println(result);

	}

}
