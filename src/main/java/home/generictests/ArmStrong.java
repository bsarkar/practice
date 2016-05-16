package home.generictests;

// Armstrong : sum of the digit  power of the length = the number
public class ArmStrong {
	public boolean solution( int N)	{
		
	int nLen = 0 ;
	int temp = N ;
	while ( temp > 0){
		temp /= 10 ;
		nLen++ ;
	}
	
	// nLen = String.valueOf(N).length();
	int sum = 0 ;
	temp = N ;
	while ( temp > 0) {
		
		int dig = temp % 10 ;
		sum += Math.pow(dig, nLen) ;
		temp /= 10 ;	
	}
	
	if ( sum == N)
		return true ;
	else
		return false ;
	}

	public static void main(String[] args) {
		System.out.println(new ArmStrong().solution(371)); // 1*1*1 + 7*7*7 + 3*3*3 = 371
		System.out.println(new ArmStrong().solution(523));
		System.out.println(new ArmStrong().solution(153));

	}

}
