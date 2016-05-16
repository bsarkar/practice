package home.hackerrank;

public class HeightTreee {

	public  int getHeight(Node nd){
		
		if ( nd == null)
			return 0 ;
		int leftLen = getHeight(nd.left);
		int rightLen = getHeight(nd.right);
		return Math.max(leftLen, rightLen) + 1 ;
		
	}

	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(5) ;
		root.right = new Node(10) ;
		root.left.left = new Node(15);
		root.left.right = new Node(20) ;
		root.left.left.left = new Node(25) ;
		
		System.out.println(new HeightTreee().getHeight(root));
		
	}

}

  class Node {
	public  Node left ;
	public  Node right ;
	int data ;
	public Node( int a){
		this.data = a ;
		this.left = null ;
		this.right = null ;
	}
	public int getValue() {
		return data ;
	}
}
