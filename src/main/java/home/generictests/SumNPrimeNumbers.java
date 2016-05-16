package home.generictests;

public class SumNPrimeNumbers {

	public boolean isPrime(int a){
		
		for ( int i = 2 ; i <= Math.sqrt(a) ; i++) {
			if( a % i == 0)
				return false ;
		}
		return true ;
	}
	public int solution( int N){
		int sum = 0 ;
		for (int i = 2 ; i <= N ; i++){
			if ( isPrime(i)) {
				System.out.println("Value:" + i + "\n");
				sum += i ;
			}
		}
		return sum ;
	}
	public static void main(String[] args) {
		System.out.println(new SumNPrimeNumbers().solution(100)) ;

	}

}
