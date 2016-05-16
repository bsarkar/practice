package home.generictests;

public class FindDuplicateNumber {

	public int findDups(int[] a) {
		
		int maxNumber = a.length - 1;
		
		long expected = maxNumber * (maxNumber + 1) / 2 ;
		long sum = 0 ;
		for ( int i = 0 ; i < a.length ; i++)	{
			sum += a[i] ;
		}
		return (int)( Math.abs(sum -  expected)) ;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 1 ,2 , 3 , 4 , 5 , 6, 7 ,7 , 8 } ;
		int result = new FindDuplicateNumber().findDups(arr) ;
		System.out.println(result);

	}

}
