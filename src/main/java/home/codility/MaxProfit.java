package home.codility;

public class MaxProfit {

	public int solution( int[] stock) {
		
		int min = 0;
		//int buy = 0;
		//int sell = 0 ;
		long diff = 0 ;
		long maxdiff = 0;
		
		if (stock.length == 0) throw new RuntimeException("Bad Data");
		if ( stock.length == 1) return 0;
		
		for ( int i = 0 ; i< stock.length ; i++) {
			if ( stock[i] < stock[min])
					min = i ;
			diff = stock[i] - stock[min] ;
			if ( diff > maxdiff) {
				//buy = min ;
				//sell = i;
				maxdiff = diff ;

			}
		}
		return (int)(maxdiff);
		
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 5 , 4 , 7 , 9 , 2 , 5 };
        int result = new MaxProfit().solution(arr) ;
        System.out.println(result);
	}

}
