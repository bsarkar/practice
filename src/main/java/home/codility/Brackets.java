package home.codility;

import java.util.Stack;

public class Brackets {

	public int solution(String st) {
	Stack stack = new Stack();
	char [] charArr = st.toCharArray();
	char tmp  ;
	for ( char a : charArr) {
		if ( (a == '(')  || ( a== '{') || (a == '[')) 
				stack.push(a);
		else {
			tmp = (Character) stack.pop() ;
			if ( !isValid(tmp, a)) 
				return 0;
		}
	}
	return 1;
	
	}
	boolean isValid( char a , char b ) {
		if ( (a == '(') && ( b == ')')) return true ;
		if ( (a == '{') && ( b == '}')) return true ;
		if ( (a == '[') && ( b == ']')) return true ;
		
		return false;
	}
	public static void main(String[] args) {
		int result = new Brackets().solution("(([]))") ;
        System.out.println(result);
        result = new Brackets().solution("({[])") ;
        System.out.println(result);

	}

}
