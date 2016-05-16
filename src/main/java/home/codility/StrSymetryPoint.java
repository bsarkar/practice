package home.codility;

public class StrSymetryPoint {

	public int solution( String S ) {
		char [] A = S.toCharArray() ;
		int l = S.length() ;
		if ( l % 2 == 0 )
			return -1 ;
		for ( int i = 0 ; i < l/2 ; i++) {
			if ( A[i] != A[l - 1 - i]) {
				return -1 ;
			}
		}
		return l/2 ;
	}
	public static void main(String[] args) {
		
        int result = new StrSymetryPoint().solution("abcdEdcba") ;
        System.out.println(result);

	}

}
