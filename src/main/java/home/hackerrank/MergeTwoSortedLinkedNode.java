package home.hackerrank;

public class MergeTwoSortedLinkedNode {

	public Node solution(Node l1 , Node l2){
		
		if ( l1 == null)
			return l2;
		if ( l2 == null)
			return l1 ;
		Node currentL1 = l1;
		Node currentL2 = l2 ;
		Node temp = null ;
		if ( currentL1.data <= currentL2.data) {
			temp = currentL1 ;
			temp.right = solution(currentL1.right , currentL2);
		}
		else {
			temp = currentL2 ;
			temp.right = solution(currentL2.right , currentL1);
		}
		return temp;
	}
	public static void main(String[] args) {
		
		//
		//
		//THIS IS ACTUALLY MERGING TWO NODES.I JUST USED THE LINKEDLIST AS I HAD SOME USEFUL METHODS. 
		// IT'S ONLY USING 'RIGHT' CHAIN.
		
		LinkedListNode ll = new LinkedListNode();
		ll.addDataTail(1);
		ll.addDataTail(3);
		ll.addDataTail(5);
		ll.addDataTail(7);
		ll.addDataTail(9);
		
		System.out.println("\nOriginal\n");
		ll.display(ll.head);
		
		
		LinkedListNode ll2 = new LinkedListNode();
		ll2.addDataTail(2);
		ll2.addDataTail(4);
		ll2.addDataTail(6);
		
		System.out.println("\nOriginal\n");
		ll2.display(ll2.head);
		
		Node ret = new MergeTwoSortedLinkedNode().solution(ll.head , ll2.head) ;
		
		while( ret.right != null) {
			System.out.println("->>" + ret.data);
			ret = ret.right;
		}
		

	}

}
