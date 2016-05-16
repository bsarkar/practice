package home.generictests;

public class Reverse {
	String revStr="";
	public String reverse(String inp) {
		if ( inp == null || inp.length() == 1 ){
			return inp ;
		}
		int i = inp.length() ;
		revStr += inp.charAt(inp.length() -1) + reverse(inp.substring(0,inp.length() -1 )  );
		return revStr;
	}

	public static void main(String[] args) {
		String ret = new Reverse().reverse("abcdefg54321");
		System.out.println(ret);

	}

}
