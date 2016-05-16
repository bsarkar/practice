package home.hackerrank;

import java.util.Iterator;
import java.util.LinkedList;

public class ReverseLinkedList {

	public LinkedListNode solution(LinkedListNode nd, int indx) {
		return null ;
	}
	public static void main(String[] args) {
		LinkedListNode ll = new LinkedListNode();
		ll.addDataTail(1);
		ll.addDataTail(2);
		ll.addDataTail(3);
		ll.addDataTail(4);
		ll.addDataTail(5);
		
		System.out.println("\nOriginal\n");
		ll.display(ll.head);
		System.out.println("\nAfter Reverse returned node\n");
		ll.display(ll.reverseLinkedList());
		System.out.println("\nAfter Reverse head node\n");
		ll.display(ll.head);
		
		ll.addDataHead(6);
		ll.addDataHead(7) ;
		
		System.out.println("\nAfter Insert head node\n");
		ll.display(ll.head);
		
		ll.display(ll.reverseLinkedList());
		System.out.println("\nAfter Reverse head node\n");
		ll.display(ll.head);

	}

}

class LinkedListNode {
	Node head;
	Node tail ;
	int size = 0 ;
	public LinkedListNode() {
		head = null ;
	}
	
	
	public void addDataTail( int data){
		Node nd = new Node(data) ;
		if ( head == null) {
			head = nd ;
			tail = nd ;
		}
		else {
			tail.right = nd ;
			nd.left = tail ;
			tail = nd ;
		}
		size++ ;
	}
	
	public void addDataHead( int data){
		Node nd = new Node(data) ;
		if ( head == null) {
			head = nd ;
			tail = nd ;
		}
		else {
			head.left = nd ;
			nd.right = head ;
			head = nd ;
		}
		size++ ;
	}
	
	public void display(Node head) {
		Node current = head ;
		while ( current != null){
			System.out.print("-->" + current.data);
			current = current.right ;
		}
		
	}
	
	public Node reverseLinkedList() {
		Node current = head ;
		
		Node temp = null ;
		while ( current != null){
			temp = current.left ;
			current.left = current.right;
			current.right = temp ;
			current = current.left ;
		}
		head = temp.left;
		return temp.left;
		
	}
	
	// Note revering from right and left. Could be done that way too.
	public Node reverseLinkedListRecursive(Node head) {
		
		if( head == null || head.right == null)
			return head;
		
		Node temp = head.right;
		head.right = null;
		
		Node rest = reverseLinkedListRecursive(temp);
		temp.right = head;
//		head = rest ;
		return rest ;	
	}
	
	public int insertNodeAt(int index, int data) {
		Node current = head;
		int i=1;
		while ( i < index) {
			if ( current == null)
				return -1 ;
			current = current.right ;	
			i++;
		}
		Node nd = new Node(data);
		Node temp = current.right;
		nd.right = temp;
		nd.left = current ;
		current.right = nd;
			
		return 1;
	}
	
	public int deleteNodeAt(int index){
		Node current = head;
		int i = 1;
		while( i < index){
			if ( current == null)
				return -1;
			current = current.right;
			i++ ;
		}
		current.left.right = current.right;
		current.right.left = current.left ;
		
		return 1;
	}
	
}
