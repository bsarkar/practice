package home.generictests;

public class PrimeNumber {

	public boolean solution(int N){
		
		boolean b = true ;
		for (int i = 2 ; i <= Math.sqrt(N) ; i++) {
			if ( N % i == 0)
				return false ;
		}
		return b ;
	}
	public static void main(String[] args) {
		System.out.println(new PrimeNumber().solution(49));

	}

}
