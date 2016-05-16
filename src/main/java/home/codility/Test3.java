package home.codility;


	public class Test3 {
		
		public int solution(int[] A) {
	        // write your code in Java SE 8
	        
	        if ( A == null  || A.length < 3) throw new RuntimeException("Invalid Data") ;
	        
	        long mEnd = 0 ;
	        long mSlice = 0;
	        int first= 0;
	        int secd = 0 ;
	        int mJ = 0;
	        int mJStore = 0;
	        for ( int i = 0 ; i < A.length ; i++) {
	            if ( i == 0 ) {
	            	first = A[i] ;
	            	mEnd = A[i] ;
	            }
	            for ( int j = i + 1 ; j < A.length ; j++) {
	                if( j == i + 1) {
	                	secd = A[j] ;
	                }
	            if ( A[j] != first && A[j] != secd) break ;
	            mEnd = Math.max(first,mEnd + A[j]);
	            mSlice = Math.max(mSlice, mEnd) ; // Store if only more than prev
	            mJ = j ;
	            }
	            mJStore = Math.max(mJ,mJStore) ;
	        }
	        return (int)mJStore;
		}
		
		public static void main(String[] args) {
			int [] arr = new int[] { 5, 4, 4, 5, 0, 12 };
			// arr = new int[] { 5  };
	        int result = new Test3().solution(arr) ;
	        System.out.println(result);

		}

	}

