package home.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

//BFS : levelOder/levelOrderReverse
//DFS : PreOrde/InOrder/PostOrder

public class BTreeLevelOrderReverse {

	public void solution(BTree bt) {
		
		Stack<Node> st = new Stack();
		Queue<Node> q = new LinkedList() ;
		q.add((Node) bt.root) ;
		while ( !q.isEmpty()) {
			Node nd = (Node) q.remove() ;
			if(nd.right != null)
				q.add(nd.right) ;
			if( nd.left != null)
				q.add(nd.left);
			st.push(nd);
			
		}
		while (! st.isEmpty()) {
			System.out.println("Node:" + st.pop().getValue());
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
		
		bt.display(bt.root);
		new BTreeLevelOrderReverse().solution(bt) ;
		
		

	}

}
