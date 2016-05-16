package home.generictests;

public class ReverseNumber {

	public long reverse(long inp) {
		long ret = 0;
		while ( inp != 0)	{
			ret = ret * 10  + inp % 10 ;
			inp /= 10 ;
		}
		return ret ;
	}
	public static void main(String[] args) {
		long ret = new ReverseNumber().reverse((long)123456);
		System.out.println(ret);

	}

}
