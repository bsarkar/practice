package home.codility;

import java.io.*;
import java.util.Arrays;

public class CountNonDivisible {
	// CountNonDivisible
	
    public  int[] solution(int[] A) {
        int[][] D = new int[A.length * 2 + 1][2];

        for (int i = 0; i < A.length; i++) {
            D[A[i]][0]++;
            D[A[i]][1] = -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (D[A[i]][1] == -1) {
                D[A[i]][1] = 0;
                for (int j = 1; j <= Math.sqrt(A[i]); j++) {
                    if (A[i] % j == 0 && A[i] / j != j) {
                        D[A[i]][1] += D[j][0];
                        D[A[i]][1] += D[A[i] / j][0];
                    } else if (A[i] % j == 0 && A[i] / j == j) {
                        D[A[i]][1] += D[j][0];
                    }
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - D[A[i]][1];
        }
        return A;
    }
    
    /*
    public int[] solution(int[] A) {
    	      int N = A.length<<1;
    	      int[] mark = new int[N+1];
    	      for (int i = 0; i < A.length; i++) {
    	           mark[A[i]]++;
    	      }
    	
             int[] divisorCount = new int[N+1];
    	         for (int i = 0; i < A.length; i++) {
    	             if (mark[A[i]] > 0) {
    	                int k = A[i];
    	                 while (k <= N) {
    	                    divisorCount[k] += mark[A[i]];
    	                    k += A[i];
    	               }
    	                mark[A[i]] = 0;
    	             }
    	        }
    	
    	       int[] ret = new int[A.length];
               for (int i = 0; i < ret.length; i++) {
    	            ret[i] = A.length - divisorCount[A[i]];
    	        }
    	
    	        return ret;
        }
   */
	
	
    public static void main(String[] args) {
    	// CountNonDivisible
         int [] arr = new int[] { 3, 1 , 2 , 3 , 6 };
    	 int [] result = new CountNonDivisible().solution(arr) ;
    	 System.out.println(Arrays.toString(result));
    }
}