package home.codility;

import java.util.Arrays;

public class CyclicRotation {
	
	private void reverse ( int [] A , int start , int end)	{
		while ( start < end) {
			int tmp = A[start];
			A[start] = A[end];
			A[end] = tmp ;
			start++;
			end--;
		}
	}
	public void solution( int [] A , int K)	{
		// Validate input
		
		int l = A.length ;
		int k = K % l ;
		// Reverse the entire array
		reverse(A , 0 , l -1) ;
		reverse(A , 0 , k-1)	;
		reverse( A , k, l -1) ;
	}

	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 2 , 4 , 3 };
        new CyclicRotation().solution(arr, 2) ;
        System.out.println(Arrays.toString(arr));

	}

}
