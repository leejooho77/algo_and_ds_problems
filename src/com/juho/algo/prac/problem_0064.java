package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;
import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * @author Juho Lee
 * @since Sep 14, 2019
 */
public class problem_0064 {

	/**
	 * Recursively find the middle of the linked list and set it as a root.
	 * 
	 * @param head
	 * @return TreeNode
	 */
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return sortedListToBST(head, null);
    }
	
	/**
	 * If the head is equal to the tail, it means we reached at the end of the BST.
	 * Else keep find the middle and set it as a current root.
	 * Then, recursively find its left and right.
	 * 
	 * @param head
	 * @param tail
	 * @return TreeNode
	 */
	public TreeNode sortedListToBST(ListNode head, ListNode tail) {
		if(head == tail) return null;
		ListNode slow = head, fast = head;
		while(fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head, slow);
		root.right = sortedListToBST(slow.next, tail);
		return root;
	}
	
}
