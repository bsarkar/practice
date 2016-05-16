package home.hackerrank;

import java.util.Stack;

public class BTreeDFSRecursive {

	public int kthSmallestElement(BTree bt, int k){
		Node current = bt.root ;
		int ret = 0 ;
		if ( k == 0 || bt == null)
			return 0 ;
		Stack<Node> sbt = new Stack<>() ;
		
		while ( !sbt.isEmpty() || current != null) {
			if ( current != null) {
				sbt.push(current) ;
				current = current.left ;
			}
			else {
				Node temp = sbt.pop() ;
				k-- ;
				if ( k == 0) {
					ret = temp.data ;
				}
				current = temp.right ;
			}
		}
		return ret ;
		
	}
	
	// PREORDER
	public void printPreOrder(BTree bt){
		
		printLevelPreOrderRecursive(bt.root);
			
	}
	
	// INORDER
	public void printInOrder(BTree bt){
		
		printLevelInOrderRecursive(bt.root);
			
	}

	// POSTORDER
	public void printPostOrder(BTree bt){
		
		printLevelPostOrderRecursive(bt.root);
			
	}
	public void printLevelPreOrderRecursive(Node nd){
		if ( nd == null)
			return ;
		System.out.println( nd.data + " ");
		printLevelPreOrderRecursive(nd.left) ;
		printLevelPreOrderRecursive(nd.right);
	}
	
	public void printLevelInOrderRecursive(Node nd){
		if ( nd == null)
			return ;
		printLevelInOrderRecursive(nd.left) ;
		System.out.println( nd.data + " ");
		printLevelInOrderRecursive(nd.right);
	}
	
	public void printLevelPostOrderRecursive(Node nd){
		if ( nd == null)
			return ;
		printLevelPostOrderRecursive(nd.right) ;
		System.out.println( nd.data + " ");
		printLevelPostOrderRecursive(nd.left);
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
//		System.out.println("\nHeight of the Tree\n");
//		System.out.println(new BTree().heightOfBtre(bt.root));
//		
//		int ret = new BTreeSolutions().kthSmallestElement(bt, 4) ;
//		System.out.println("Returned data ->" + ret);
		System.out.println("\nNode-Left-Right\n");
		new BTreeDFSRecursive().printPreOrder(bt);
		System.out.println("\nLeft-Node-Right\n");
		new BTreeDFSRecursive().printInOrder(bt);
		System.out.println("\nRight-Node-Left\n");
		new BTreeDFSRecursive().printPostOrder(bt);

	}

}

class BTree {
	Node root ;

	public BTree() {
		root = null ;
	}

	public void insert(int data) {
		Node nd = new Node(data);
		if ( root == null)	{
			root = nd ;
			return ;
		}

		Node current = root ;
		Node parent = null ;
		while( true) {
			parent = current ;
			if ( data < current.data ) {
				current = current.left ;
				if ( current == null) {
					parent.left = nd ;
					return ;
				}
			}
			else {
				current = current.right ;
				if ( current == null) {
					parent.right = nd ;
					return ;
				}
			}
		}
	}
	
	public Node delete(int data){
		
		Node current = root;
		Node parent = root ;
		boolean leftChild = false ;
		
		while( current.data != data) {
			if( data < current.data){
				// Go left
				leftChild = true ;
				current = current.left ;		
			}
			else {
				leftChild = false ;
				current = current.right ;
			}
			if ( current == null){
				// Exhausted and didn't find 
				return null ;
			}
			
		}
		// If we are here, we found the node
		// Case where no child of the node just found
		
		// TODO : if Root case
		if ( current.left == null && current.right == null){
			if ( current == root) {
				root = null ;
			}
			else {
				parent.left = null;
				parent.right = null ;
			}
			return current;
		}
		// It has left Child only
		if ( current.left != null && current.right == null)	{
			if ( current == root){
				root.left = current.left ;
			}
			else {
				parent.left = current.left ;
			}
			return current ;
		}
		// It has Right Child Only
		if( current.left == null && current.right != null){
			if ( current == root){
				root.right = current.right ;
			}
			else {
				parent.right = current.right ;
			}
			return current ;
		}
		
		// Has both left and right legs
		
		// Find Successor and 
		// based on leftChild = true or false, assign left or right leg of parent
		
		Node successor = getSuccessor(current);
		if ( current == root){
			root = successor ;
		}
		else {
			if(leftChild){
				parent.left = successor ;
			}
			else
				parent.right = successor ;
		}
		
		successor.left = current.left ;
		
		return current ;
	}
	
	public Node getSuccessor(Node deleteNode){
		Node successor = null ;
		Node successorParent = null ;
		
		// Need to take right leg of the deleted node
		Node current = deleteNode.right ;
		while ( current != null){
			// keep looking the left leg
			successorParent = successor ;
			successor = current ;
			current = current.left ;
		}
		if ( successor != deleteNode.right){
			
			// Make sure to undestand this
			successorParent.left = successor.right ;
			successor.right = deleteNode.right;
		}
		
		return successor ;
	}
	
	public void display(Node root) {
		if( root != null){
			display( root.left);
			System.out.println(" " + root.data);
			display( root.right) ;
		}
	}
	
	public int heightOfBtre(Node root){
		
		if ( root == null)
			return 0;
		int leftHeight = heightOfBtre(root.left)	;
		int rightHeight = heightOfBtre( root.right) ;
		
		return Math.max(leftHeight, rightHeight) + 1;
		
	}
}
