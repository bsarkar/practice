package home.generictests;

public class StringToNumber {

	public int solution(String str) {
		
		char [] arr = new char[255] ;
		
		arr = str.toCharArray();
		
		int asciiZero = (int) '0' ;
		int sum = 0 ;
		int j = 0 ;
		for ( int i = arr.length -1 ; i >= 0 ; i-- , j++){
			int dig = ((int)arr[i] - asciiZero );
			sum += Math.pow(10, j) * dig ;
		}
		return sum ;
	}
	public static void main(String[] args) {
		System.out.println(new StringToNumber().solution("1234"));

	}

}
