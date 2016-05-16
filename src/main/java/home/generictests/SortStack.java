package home.generictests;

import java.util.Stack;

// 
public class SortStack {

	public Stack<Integer> solution(Stack<Integer> input){
	
		Stack<Integer> storeStack = new Stack<>();
		
		while ( !input.isEmpty() ) {
			Integer tmp = input.pop() ;
			while(!storeStack.isEmpty() && storeStack.peek() > tmp) {
				input.push(storeStack.pop()) ;
			}
			storeStack.push(tmp) ;
		}

		return storeStack ;
	}
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(new Integer(2)) ;
		st.push(new Integer(6)) ;
		st.push(new Integer(4)) ;
		st.push(new Integer(3)) ;
		
		Stack<Integer> ret = new SortStack().solution(st) ;
		System.out.println(ret);

	}

}
