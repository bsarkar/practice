package home.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public int solution( int[] arr , int n) {
		
		
		Set<Integer> newList = new HashSet<Integer>() ;
		
		for (int i = 0 ; i < arr.length ; i++) {
			if ( arr[i] <= 0 || arr[i] > n)
				throw new RuntimeException("Invalid");
			newList.add(arr[i]);
		
		if ( newList.size() == n)
			return i;
		}
		return -1;
		
		/*
		 int [] visited = new int [n] ;
		 
		int notVisited = n ;
		
		for ( int i = 0 ; i < arr.length ; i++) {
			visited[i] = -1 ;
		}
		for ( int i = 0; i < arr.length ; i++) {
			int idx = arr[i] ;
			if ( visited[idx] != -1) continue ;
			visited[idx] = 1 ;
			notVisited -= 1 ;
			if ( notVisited == 0) return i ;
		}
		return -1 ;
		*/
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 2 , 4 , 1 , 6 };
        int result = new FrogRiverOne().solution(arr, 5) ;
        System.out.println(result);
	}

}
