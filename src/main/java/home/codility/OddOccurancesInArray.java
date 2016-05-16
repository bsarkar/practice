package home.codility;

public class OddOccurancesInArray {

	public int solution ( int [] A ) {
		
//		int missing = A[0] ;
//		for ( int i = 1 ; i < A.length ; i++)	{
//			missing ^= A[i] ;
//		}
		int missing = 0 ;
		for ( int a : A) {
			missing ^= a ;
		}
		return missing ;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 1 , 4 , 3 };
        int result = new OddOccurancesInArray().solution(arr) ;
        System.out.println(result);

	}

}
