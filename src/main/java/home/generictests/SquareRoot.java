package home.generictests;

public class SquareRoot {

	public int solution(int n) {
		int t = 0 ;
		int sqroot = n / 2 ;
		
		do {
			t = sqroot ;
			sqroot = ( t + n/t ) / 2 ;
			
		} while ( (t - sqroot) > 0) ;
		
		return sqroot;
	}
	public static void main(String[] args) {
		int ret = new SquareRoot().solution(16);
		System.out.println(ret);

	}

}
