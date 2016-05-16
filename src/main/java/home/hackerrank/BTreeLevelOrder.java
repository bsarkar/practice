package home.hackerrank;

import java.util.LinkedList;
import java.util.Queue;

import javax.lang.model.element.QualifiedNameable;

// BFS : levelOder/levelOrderReverse
// DFS : PreOrde/InOrder/PostOrder

public class BTreeLevelOrder {

	public void solution(BTree bt) {
		
		Queue<Node> q = new LinkedList();
		q.add(bt.root);
		
		while(!q.isEmpty()){
			Node nd = q.remove() ;
			System.out.println(nd.getValue());
			if( nd.left != null)
				q.add(nd.left) ;
			if( nd.right != null)
				q.add(nd.right);
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
		new BTreeLevelOrder().solution(bt) ;

	}

}
