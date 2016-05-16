package home.generictests;

public class ReverseLinkList {

	public ListNode solutionRecursive(ListNode head) {
		// 
		if ( head == null || head.next == null)
			return head ;
		ListNode secnd = head.next ;
		head.next = null ;
		
		ListNode rest = solutionRecursive(secnd);
		secnd.next = head ;
		return rest;
		
	}
	
	public Node solution(Node head) {
		if ( head == null || head.next == null)
			return head;
		Node p1 = head ;
		Node p2 = head.next;
		
		head.next = null ;
		
		while (p1 != null && p2 != null){
			Node temp = p2.next;
			p2.next = p1 ;
			p1 = p2;
			if ( temp != null){
				p2 = temp ;
			}
			else {
				break ;
			}
		}
		return p2 ;
	}
	
	// Easy to understand
	
	public Node solution2( Node head){
		Node prev = null ;
		Node curr = head ;
		Node next = null ;
		
		while ( curr != null){
			
			next = curr.next ;
			curr.next = curr.pre ;
			prev = curr ;
			curr = next ;
		}
		
		// At this point curr and next pointing to NULL and prev to last node
		head = prev ;
		return head ;
	}
	public static void main(String[] args) {
		ListNode nd = new ListNode(1);
		nd.next = new ListNode(2) ;
		nd.next.next = new ListNode(3) ;
		
		ListNode ret = new ReverseLinkList().solutionRecursive(nd) ;
		while( ret != null){
			System.out.println(ret.value);
			ret = ret.next ;
		}
		
		Node nd2 = new Node(1,1);
		nd2.next = new Node(2,2) ;
		nd2.next.next = new Node(3,3) ;
		
//		Node ret2 = new ReverseLinkList().solution(nd2) ;
		Node ret2 = new ReverseLinkList().solution(nd2) ;
		while( ret2 != null){
			System.out.println(ret2.value);
			ret2 = ret2.next ;
		}

	}

}
