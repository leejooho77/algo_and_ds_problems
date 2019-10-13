package com.juho.algo.prac;

import java.util.ArrayDeque;
import java.util.Deque;

import com.juho.algo.prac.ds.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * Input: 1->2, Output: false
 * 
 * Example 2:
 * Input: 1->2->2->1, Output: true
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * @author Juho Lee
 * @since Oct 13, 2019
 */
public class problem_0109 {
	
	public boolean isPalindrome(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode fast = dummyHead, slow = dummyHead;
		// finding the mid point of linked list
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode newHead = slow;
		slow = slow.next;
		newHead.next = null;
		// reverse the list from mid to end
		while(slow != null) {
			ListNode temp = slow.next;
			slow.next = newHead;
			newHead = slow;
			slow = temp;
		}
		// check if it is palindrome
		while(head != null && newHead != null) {
			if(head.val != newHead.val)
				return false;
			head = head.next;
			newHead = newHead.next;
		}
		return true;
	}

	public boolean isPalindromeWithStack(ListNode head) {
		Deque<Integer> deque = new ArrayDeque<>();
		ListNode pointer = head;
		while(pointer != null) {
			deque.push(pointer.val);
			pointer = pointer.next;
		}
		while(head != null && !deque.isEmpty()) {
			if(head.val != deque.pop()) return false;
			head = head.next;
		}
		return true;
	}
	
}
