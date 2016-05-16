package home.codility;

public class TieRopes {

	public int solution( int K , int [] A)	{
		
		int curr = 0 ;
		int cnt = 0 ;
		for ( int a : A )	{
			curr += a ;
			if ( curr  >= K ) {
				cnt += 1 ;
				curr = 0 ;
			}
		}
		return cnt ;
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 2 , 4 , 3 };
        int result = new TieRopes().solution(4 ,arr) ;
        System.out.println(result);

	}

}
