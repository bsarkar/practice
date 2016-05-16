package home.generictests;

public class Test {

	public int solution() {
		int a = '1' - '0';
		char c = 5 + '0';
		String st = "abc" + c ;
		System.out.println(st);
		return a;
	}
	public static void main(String[] args) {
		int ret = new Test().solution();
		System.out.println(ret);

	}

	
}
