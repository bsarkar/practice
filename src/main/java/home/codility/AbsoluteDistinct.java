package home.codility;

import java.util.HashSet;
import java.util.Set;

public class AbsoluteDistinct {

	public int solution(int[] A) {
		
		Set<Integer> uSet = new HashSet<Integer>();
		
		if ( A == null) throw  new RuntimeException("Invalid Data")	;
		
		for (int  a : A)	{
			uSet.add( Math.abs(a)) ;
		}
		
		return uSet.size() ;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 3 , 4 , -3 };
        int result = new AbsoluteDistinct().solution(arr) ;
        System.out.println(result);

	}

}
