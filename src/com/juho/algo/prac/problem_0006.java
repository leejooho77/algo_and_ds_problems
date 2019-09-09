package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

/**
 * Given a singly-linked list, reverse the list. 
 * This can be done iteratively or recursively. Can you get both solutions?
 * 
 * Example:
 * Input: 4 -> 3 -> 2 -> 1 -> 0 -> NULL, Output: 0 -> 1 -> 2 -> 3 -> 4 -> NULL
 * 
 * @author Juho Lee
 * @since Jul 23, 2019
 */
public class problem_0006 {
	
	public ListNode reverseListIterative(ListNode head) {
		if(head == null) return null;
		ListNode next = head.next;
        head.next = null;
		while(next != null) {
			ListNode temp = next.next;
			next.next = head;
			head = next;
			next = temp;
		}
		return head;
	}
	
	public ListNode reverseListRecursive(ListNode head) {
		if(head == null) return null;
		return reverseListRecursiveHelper(head);
	}
	
	public ListNode reverseListRecursiveHelper(ListNode head) {
		if(head.next == null) return head;
		ListNode newHead = reverseListRecursiveHelper(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

}
