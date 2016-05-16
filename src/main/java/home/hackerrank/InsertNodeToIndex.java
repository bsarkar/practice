package home.hackerrank;

public class InsertNodeToIndex {

	public static void main(String[] args) {
		LinkedListNode ll = new LinkedListNode();
		ll.addDataTail(1);
		ll.addDataTail(2);
		ll.addDataTail(5);
		ll.addDataTail(6);
		
		System.out.println("\nOriginal...\n");
		ll.display(ll.head);
		
		Node nd = ll.reverseLinkedListRecursive(ll.head) ;
		System.out.println("\nReverseRecursive...\n");
		ll.display(nd);
		
		
		
		ll.insertNodeAt(2 , 3) ;
		System.out.println("\nAfter Insert...\n");
		ll.display(ll.head);
		
		ll.deleteNodeAt(3) ;
		System.out.println("\nAfter Delete...\n");
		ll.display(ll.head);
		
	}

}
