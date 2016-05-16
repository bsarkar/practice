package home.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci1 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        String A = s.next();
        String B = s.next();
        int N = s.nextInt();
        
  //      if ( A > 0 && B > 2) throw new InputArgumentException("Bad data");
        
        BigInteger[] arr = new BigInteger[N+1];
         arr[0] = new BigInteger(A);
         arr[1] = new BigInteger(B);

        for (int i= 2 ; i < N+1 ; i++) {
            arr[i] = arr[i-1].pow(2).add(arr[i-2]) ;
        }

        System.out.println(arr[N-1]);
		

	}

}
