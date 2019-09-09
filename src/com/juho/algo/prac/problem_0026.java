package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * 
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * @author leejooho77
 * @since Aug 12, 2019
 */
public class problem_0026 {

	public ListNode removeNthFromEnd(ListNode head, int k) {
		if(k == 0) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while(k-- > 0) {
			fast = fast.next;
		}
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
	
}
