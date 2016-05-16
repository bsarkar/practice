package home.codility;

public class TapeEquilibrium {

	
	// TapeEquilibrium
		
		public int solution(int[] A) {
			
			int n = A.length;
			if (n <= 0)
			return -1;

			long sum = A[0] + A[n - 1];
			for (int leftcount = 0, rightCount = n - 1; leftcount < rightCount - 1;) {
			long tmpLeftSum = sum + A[leftcount + 1];
			long tmpRightSum = sum + A[rightCount - 1];

			if(Math.abs(tmpLeftSum) <= Math.abs(tmpRightSum)){
			leftcount++;
			sum = tmpLeftSum;
			}
			else{
			rightCount--;
			sum = tmpRightSum;
			}

			if(rightCount - leftcount == 1 && sum == 0){
			return leftcount + 1;
			}

			}
			return -1;

/*
		    long sumright = 0;
		    long sumleft = 0;
		    long ans;

		    for (int i =1;i<A.length;i++)
		        sumright += A[i];

		    sumleft = A[0];
		    ans =Math.abs(sumright+sumleft);

		    for (int P=1; P<A.length; P++)
		    {
		        if (Math.abs(sumleft - sumright)<ans)
		            ans = Math.abs(sumleft - sumright);
		        sumleft += A[P];
		        sumright -=A[P];
		    }
		    return (int) ans; 
  */
		}
		
	public static void main(String[] args) {
		
		// TapeEquilibrium
    	
        int [] arr = new int[] { -1, -1, 3 , -4 , 5 , 1 , -6, 2 , 1 , -1};
        int result = new TapeEquilibrium().solution(arr) ;
        System.out.println(result);
        

	}

}
