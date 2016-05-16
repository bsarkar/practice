package home.codility;

public class MaxSliceSum {
	
	public int solution(int[] arr) {
		int mEnd = 0;
		int mSlice = 0;
		if (arr.length == 0) throw new RuntimeException("Empty Data");
		for (int i = 0 ; i< arr.length ; i++) {
			mEnd = Math.max( 0,mEnd + arr[i]);
			mSlice = Math.max(mSlice ,  mEnd); // Store only if more than prev val
		}
		return mSlice ;
		 
	}

	public static void main(String[] args) {
		int [] arr = new int[] { 5 , -7 , 3 , 5 , -2 , 4 , -1 };
		// arr = new int[] { 5  };
        int result = new MaxSliceSum().solution(arr) ;
        System.out.println(result);

	}

}
