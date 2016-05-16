package home.generictests;



public class BinaryToDecimal {

	public int solution(int x){

//		int number = 0 ;
//		int i = 0 ;
//		while ( N >  0)	{
//			int bit = N % 10 ;
//			number += bit == 1 ? Math.pow( 2, i) : 0 ;
//			i++ ;
//			N /= 10 ;
//		}
//		return number ;
//		// return (int)'A' ;
		
		return x!= 0 ? (x & 1) + solution(x >> 1): 0 ;
//		
//		int a = x & 1 ;
//		int b = x 
				
//		int i = 0;
//		int[] nums = { 8, 0, 4, 0, 2, 6 };
//		do {
//		  if (nums[i] == 0)
//		    continue;
//		  System.out.println(nums[i]);
//		} while (++i < nums.length);
		
//		int x= 5;
//		int y=10;
//		System.out.println((++y - x++));
		
//		Thread t = new SomeThread();

//		return 1;
	}

	public static void main(String[] args) {

//		int result  = new BinaryToDecimal().solution(1000);
//		System.out.println(result);
		int a = new BinaryToDecimal().solution(4);
		System.out.println(a);


	}

}

