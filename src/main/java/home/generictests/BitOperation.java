package home.generictests;

public class BitOperation {

	public void solutionBinayToDec(int N) {
		int number = 0 ;
		int i = 0 ;
		while ( N >  0)	{
			int bit = N % 10 ;
			number += bit == 1 ? Math.pow( 2, i) : 0 ;
			i++ ;
			N /= 10 ;
		}
		System.out.println("\nBinaryToDec:" + number); 
	}
	
	public void solutionDecToBianry(long N){
		int [] arr = new int [255] ;
		int i = 0 ;
		while ( N > 0 ){
			arr[i++] = (int) (N % 2) ;
			N /= 2;
		}
		System.out.println("\nDecToBinary");
		for ( int j = i - 1 ; j >= 0 ; j--) {
			System.out.print(arr[j])	;
		}
		
	}
	
	public void solution(int N , int M) {
		
		int ret =0;
		ret = N ^ M ;
		System.out.println("\nReturn:" + ret);
		System.out.println("\nReturnBinary:\n" );
		this.solutionDecToBianry(ret);
	}
	
	public static void main(String[] args) {
		new BitOperation().solutionBinayToDec(11110111);
		new BitOperation().solutionDecToBianry(255);
		new BitOperation().solution(8,247);
//		System.out.println(result);

	}

}
