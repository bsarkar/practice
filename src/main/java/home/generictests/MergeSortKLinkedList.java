package home.generictests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int value;
	ListNode next;
 
	ListNode(int v) {
		value = v;
		next = null;
	}
}

public class MergeSortKLinkedList {
	 
		public ListNode mergeKLists(ArrayList<ListNode> lists) {
			if (lists.size() == 0)
				return null;
	 
			//PriorityQueue keeps elements based on set priority which comparator determines
			PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
					new Comparator<ListNode>() {
						public int compare(ListNode a, ListNode b) {
							if (a.value > b.value)
								return 1;
							else if(a.value == b.value)
								return 0;
							else 
								return -1;
						}
					});
	 
			//add first node of each list to the queue
			for (ListNode list : lists) {
				if (list != null)
					q.add(list);
			}
	 
			ListNode head = new ListNode(0);
			ListNode p = head; 
	 
			while (q.size() > 0) {
				ListNode temp = q.poll();
				p.next = temp;
	 
				// add next element : one from each list
				if (temp.next != null)
					q.add(temp.next);
	 
				p = p.next;
			}
	 
			return head.next;
		}
		
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ln1.next = new ListNode(3);
		ln1.next.next = new ListNode(8);
		ln1.next.next.next = new ListNode(10);
		ln1.next.next.next.next = new ListNode(12);
		
		ListNode ln2 = new ListNode(4);
		ln2.next = new ListNode(6);
		ln2.next.next = new ListNode(7);
		
		ListNode ln3 = new ListNode(5);
		ln3.next = new ListNode(11);
		
		ListNode ln4 = new ListNode(2);
		ln4.next = new ListNode(14);
		ln4.next.next = new ListNode(15);
		
		ArrayList<ListNode> arr = new ArrayList<>() ;
		arr.add(ln1);
		arr.add(ln2);
		arr.add(ln3);
		arr.add(ln4);

		ListNode ret = new MergeSortKLinkedList().mergeKLists(arr);
		while ( ret != null) {
			System.out.println(ret.value);
			ret = ret.next ;
		}
	}

}
