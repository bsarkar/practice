package home.generictests;

import java.util.Arrays;

public class GenFibbonacci {
	public int[] solution(){
		
		int[] ret = new int[10];
		ret[0] = 1 ;
		ret[1] = 2 ;
		
		for ( int i = 2 ; i < 10 ; i++)	{
			ret[i] = ret[i-1] + ret[i-2] ;
		}
		return ret ;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new GenFibbonacci().solution()));

	}

}
