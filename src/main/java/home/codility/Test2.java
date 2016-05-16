package home.codility;

public class Test2 {
	    int solution(int n) {
	        int[] d = new int[30];
	        int l = 0;
	        int p;
	        while (n > 0) {
	            d[l] = n % 2;
	            n /= 2;
	            l++;
	        }
	        for (p = 1; p < 1 + l; ++p) {
	            int i;
	            boolean ok = true;
	            for (i = 0; i < l - p; ++i) {
	                if (d[i] != d[i + p]) {
	                    ok = false;
	                    break;
	                }
	            }
	            if (ok) {
	                return p;
	            }
	        }
	        return -1;
	    }
	public static void main(String[] args) {
		 int result = new Test2().solution(955) ;
		 //int result = new Test2().solution(36) ;
	       System.out.println(result);

	}

}
