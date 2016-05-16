package home.codility;

public class Ladder {
	public int[] solution(int[] A, int[] B) {
        int L = A.length;
         
        int Fib[] = new int[L + 1]; 
        Fib[0] = 1;
        Fib[1] = 1;
        int p = (1 << 30) - 1;
        for (int i = 2; i < L+1; ++i){
            Fib[i] = (Fib[i-1] + Fib[i-2]) & p;
        }
        int result[] = new int[L];
        for (int i = 0; i < L; ++i){
            p = (1 << B[i]) - 1;
            result[i] = Fib[A[i]] & p;
        }
         
        return result;
    }
	public static void main(String[] args) {
		int [] arr = new int[] { 3, 1 , 2 , 4 , 3 };
		int [] arr2 = new int[] { 3, 1 , 2 , 4 , 3 };
        int[] result = new Ladder().solution(arr, arr2) ;
        System.out.println(result);
	}

}
