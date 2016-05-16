package home.generictests;

public class Swap {
	public void solution( int a , int b) {
	    a = a + b ;
		b = a - b;
		a = a - b ;
		System.out.println(a + "/" + b );
	}
	public static void main(String[] args) {
		new Swap().solution(9, 5) ;

	}

}
