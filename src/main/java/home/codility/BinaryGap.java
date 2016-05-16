package home.codility;

public class BinaryGap {
		
		public int solution(int N ) {
			int cnt = 0 ;
			boolean newStart = false ;
			int store = 0 ;
			int tmp = N ;
			while ( tmp > 0) {
					if (( tmp & 1)	== 1 ) {
						if ( newStart == false) {
							newStart = true ;
							cnt = 0 ;
						}
					}
					else {
						cnt += 1 ;
						store = Math.max(store , cnt) ;
					  }
		
					tmp >>= 1 ;
			}
			return store ;
		}
		public static void main(String[] args) {
        int result = new BinaryGap().solution(33) ;
        System.out.println("Binary Gap:" + result);

	}

}
