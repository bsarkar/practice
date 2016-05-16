package home.generictests;

import java.util.Arrays;

public class DecimalToBinary {

	public void solution(int N){
		int [] arr = new int [255] ;
		int i = 0 ;
		while ( N > 0 ){
			arr[i++] = N % 2 ;
			N /= 2;
		}
		for ( int j = i - 1 ; j >= 0 ; j--) {
			System.out.println(arr[j])	;
		}
		
	}
	public static void main(String[] args) {
		DecimalToBinary d = new DecimalToBinary();
		d.solution(16);

	}

}
