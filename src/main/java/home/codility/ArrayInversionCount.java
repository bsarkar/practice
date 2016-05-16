package home.codility;
/*
 
 This is a solution to the Codility problem Inversion Count. An inversion is a tuple (p,q) where 
 p<q and A[p] > A[q] for a given array A
 The idea is to use a modified mergesort that counts the number of inversion pairs.
 */
import java.util.Arrays;

public class ArrayInversionCount {

	
	static int merge(int arr[], int[] left, int[] right){
		  int l = 0, r = 0, inv = 0;
		  while(l < left.length || r < right.length){
		    if(l == left.length){
		      arr[l+r] = right[r];
		      r++;
		    }
		    else if(r == right.length){
		      arr[l+r] = left[l];
		      l++;
		    }
		    else if(left[l] > right[r]){
		      arr[l+r] = right[r];
		      inv += (left.length - l);
		      r++;
		    }
		    else if(left[l] <= right[r]){
		      arr[l+r] = left[l];
		      l++;
		    }
		  }
		  return inv;
		}
	
	public int solution(int [] a)	{
		if(a.length <= 1) return 0;
		  
		  int index = a.length/2;
		  
		  int[] leftArray = Arrays.copyOfRange(a, 0, index);
		  int[] rightArray = Arrays.copyOfRange(a,index, a.length);
		  
		  return solution(leftArray) + solution(rightArray) + merge(a, leftArray,rightArray);	

	}
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 2 , 4 , 3 };
        int result = new ArrayInversionCount().solution(arr) ;
        System.out.println(result);

	}

}
