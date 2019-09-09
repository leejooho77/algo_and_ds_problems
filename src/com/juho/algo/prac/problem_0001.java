package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

/**
 * You are given two linked-lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4), Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * @author Juho Lee
 * @since July 17, 2019
 */
public class problem_0001 {

	/**
	 * @param l1			linked list representing non-negative integer
	 * @param l2			linked list representing non-negative integer
	 * @return linked list representing sum of @l1 and @l2
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0, left = 0, right = 0;
		ListNode result = new ListNode(0);
		ListNode head = result;
		while(l1 != null || l2 != null || carry != 0) {
			left = (l1 == null) ? 0 : l1.val;
			l1 = (l1 == null) ? l1 : l1.next;
			right = (l2 == null) ? 0 : l2.val;
			l2 = (l2 == null) ? l2 : l2.next;
			int sum = carry + left + right;
			carry = sum/10;
			result.next = new ListNode(sum % 10);
			result = result.next;
		}
		return head.next;
	}
	
}
