package home.generictests;

public class DeleteDuplicatesFromSortedList {

	public ListNode solution(ListNode nd){
	        if(nd == null || nd.next == null)
	            return nd;
	 
	        ListNode p = nd;
	 
	        while( p!= null && p.next != null){
	            if(p.value == p.next.value){
	                p.next = p.next.next;
	            }else{
	                p = p.next; 
	            }
	        }
	 
	        return nd;
	    }
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ln1.next = new ListNode(3);
		ln1.next.next = new ListNode(3);
		ln1.next.next.next = new ListNode(8);
		ln1.next.next.next.next = new ListNode(12);

		ListNode ret = new DeleteDuplicatesFromSortedList().solution(ln1) ;
		while ( ret != null) {
			System.out.println(ret.value);
			ret = ret.next ;
		}
	}

}
