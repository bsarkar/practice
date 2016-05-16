package home.codility;

/*
 You are given integers K, M and a non-empty zero-indexed array A consisting of N integers. 
 Every element of the array is not greater than M.You should divide this array into K blocks of
  consecutive elements. The size of the block is any integer between 0 and N. Every element of 
  the array should belong to some block.
  The sum of the block from X to Y equals A[X] + A[X + 1] + … + A[Y]. The sum of empty block 
  equals 0.The large sum is the maximal sum of any block. The goal is to minimize the large sum
  
  For example, you are given integers K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
The array can be divided, for example, into the following blocks:

[2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
 */
public class MinMaxDivision {

	private int check(int num, int K, int[] A, int N)
	{
	    int i = 0;
	    
	    int sum = 0;
	    while (i < N){    
	        //indeed, we don't need below because the lower limit is max(A).
	        if (A[i] > num){
	            return 0;
	        }
	        sum += A[i];
	        if (sum > num){
	            sum = A[i];

	            K--;
	            if (K == 0){
	                return 0;
	            }
	        }
	        i++;
	    }
	    
	    return 1;
	}
	
	// Change to long
	// check inputs
	public int solution( int K , int M, int [] A , int  N) {
		
		
		int max = 0;
	    int sum = 0;
	    
	    int i;
	    for (i = 0; i < N; i++){
	        max = max < A[i] ? A[i] : max;
	        sum += A[i];
	    }
	    
	    int beg = max;
	    int end = sum; 
	    
	    int min = sum; 
	    while (beg <= end){
	        int mid = (beg + end) / 2;
	        if (check(mid, K, A, N) == 1){
	            min = mid;
	            end = mid - 1;
	        }
	        else {
	            beg = mid + 1;
	        }
	    }
	    
	    return min;
		
	}
	public static void main(String[] args) {
		int [] arr = new int[] { 2 , 1 , 5 , 1 , 2 , 2 , 2  };
        int result = new MinMaxDivision().solution( 3 , 5 , arr , 7) ;
        System.out.println(result);

	}

}
