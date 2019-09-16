package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * 
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2, Output: 4->5->1->2->3->NULL
 * 
 * @author Juho Lee
 * @since Sep 16, 2019
 */
public class problem_0070 {
	
	public ListNode rotateRight(ListNode head, int k) {
		int length = 0;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode fast = dummyHead, slow = fast;
		while(fast.next != null) {
			fast = fast.next;
			length++;
		}
        if(length == 0) return head;
		k = length - (k % length);
		while(k-- > 0) slow = slow.next;
        fast.next = dummyHead.next;
        ListNode newHead = slow.next;
		slow.next = null;
		return newHead;
	}

}
