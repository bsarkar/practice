package home.codility;

/*Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer that does not occur in A.
For example, given:
  A[0] = 1    
  A[1] = 3    
  A[2] = 6
  A[3] = 4    
  A[4] = 1    
  A[5] = 2
the function should return 5.
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
*/
public class MissingInteger {

	public int solution(int [] arr) {
	int counter[] = new int[arr.length];

	// Count the items, only the positive numbers
	for (int i = 0; i < arr.length; i++)
	    if (arr[i] > 0 && arr[i] <= arr.length)  // arr[i] >= 0 && arr[i] <= arr.length ??
	        counter[arr[i] - 1]++;

	// Return the first number that has count 0
	for (int i = 0; i < counter.length; i++)
	    if (counter[i] == 0)
	        return i + 1;

	// If no number has count 0, then that means all number in the sequence
	// appears so the next number not appearing is in next number after the
	// sequence.
	return arr.length + 1;
  }
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 2 , 4 , 6 };
        int result = new MissingInteger().solution(arr) ;
        System.out.println(result);
	}

}
