package com.juho.algo.prac;

import java.util.Stack;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given an integer k and a binary search tree, find the floor (less than or equal to) of k, 
 * and the ceiling (larger than or equal to) of k. If either does not exist, then print them as None.
 * 
 * Here is the definition of a node for the tree.
 * 
 * @author Juho Lee
 * @since July 28, 2019
 */
public class problem_0011 {
	
	public static TreeNode[] ceilingAndFloor_1(TreeNode root, int k) {
		TreeNode floor = null;
		TreeNode ceil = null;
		int min = 0;
		int max = Integer.MAX_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.empty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(root.val > min && root.val <= k) {
				floor = root;
				min = root.val;
			}
			if(root.val < max && root.val >= k) {
				ceil = root;
				max = root.val;
			}
			root = root.right;
		}
		return new TreeNode[] {floor, ceil};
	}
	
	public static TreeNode[] ceilingAndFloor_2(TreeNode root, int k) {
		TreeNode floor = null;
		TreeNode ceil = null;
		while(root != null) {
			if(root.val > k) {
				ceil = root;
				root = root.left;
			}
			else if(root.val < k) {
				floor = root;
				root = root.right;
			}
			else {
				ceil = root;
				floor = root;
				break;
			}
		}
		return new TreeNode[] {floor, ceil};
	}

}
