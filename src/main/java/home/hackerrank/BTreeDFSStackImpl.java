package home.hackerrank;

import java.util.ArrayList;
import java.util.Stack;

public class BTreeDFSStackImpl {
	public void solutionPreOrder(BTree bt){
		
		Stack<Node> st = new Stack<>();
		Node nd = bt.root ;
		ArrayList<Integer> ret = new ArrayList<>();
		

		while (!st.isEmpty() || nd != null){
			if(nd != null) {
				st.push(nd);
				ret.add(nd.getValue()) ;
				nd = nd.left ;
			} 
			else {
				nd = st.pop();
//				System.out.println(nd.getValue());
				nd = nd.right ;
			}
		}
		
		for ( int val : ret) {
			System.out.println(val);
		}
	}
	
	// OR
	
//public void solutionPreOrder2(BTree bt){
//		
//		Stack<Node> st = new Stack<>();
//		Node nd = bt.root ;
//		ArrayList<Integer> ret = new ArrayList<>();
//		st.push(nd);
//
//		while (!st.isEmpty()){
//			Node temp = st.pop();
//			ret.add(temp.getValue()) ;
//				
//			if ( nd.right != null)
//				st.push(nd.right)  ;
//			if ( nd.left != null)
//				st.push(nd.left) ;
//		}
//		
//		for ( int val : ret) {
//			System.out.println(val);
//		}
//	}
	
	public void solutionInOrderStack( BTree bt)	{
		Stack<Node> st = new Stack<>();
		Node nd = bt.root ;

		while (!st.isEmpty() || nd != null){
			if(nd != null) {
				st.push(nd);
				nd = nd.left ;
			} 
			else {
				nd = st.pop();
				System.out.println(nd.getValue());
				nd = nd.right ;
			}
		}
	}

// Complete later
	
	public void solutionPostOrderStack( BTree bt)	{
		Stack<Node> st = new Stack<>();
		Node nd = bt.root ;
		st.push(nd) ;
		Node prev = null ;
		ArrayList<Integer> lst = new ArrayList();

		// Need to store the parent
		while (!st.isEmpty() ){
			Node curr = st.peek() ;
			if( prev == null || prev.left == curr || prev.right == curr) {
				if ( curr.left != null) {
					st.push(curr.left) ;
				}
				else if ( curr.right != null) {
					st.push(curr.right) ;
				}
				else
					lst.add(st.pop().data) ;
			}
			else {
				if( curr.left == prev) {
					if(curr.right != null) {
						st.push(curr.right) ;
					}
					else {
						lst.add(st.pop().data) ;
					}
				}
				else if( curr.right == prev) {
	 
					lst.add(st.pop().data) ;
				}
	
				
			}
			prev = curr ;	
			
		}
		for ( int val : lst) {
			System.out.println(val);
		}
	}
	
	public static void main(String[] args) {
		BTree bt = new BTree() ;
		bt.insert(20);
		bt.insert(15);
		bt.insert(25);
		bt.insert(10);
		bt.insert(18);
		bt.insert(16);
		bt.insert(19);
		bt.insert(17);

//		bt.display(bt.root);

		System.out.println("\nInOrdeStack\n");
		new BTreeDFSStackImpl().solutionInOrderStack(bt);
		System.out.println("\nPreOrderStack\n");
		new BTreeDFSStackImpl().solutionPreOrder(bt);
		System.out.println("\nPostOrderStack\n");
		new BTreeDFSStackImpl().solutionPostOrderStack(bt);
		

	}

}
