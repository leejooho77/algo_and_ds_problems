package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * Given binary tree [3,9,20,null,null,15,7], return 3
 * 
 * @author Juho Lee
 * @since Aug 27, 2019
 */
public class problem_0041 {

	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;
		return Math.max(left, right);
	}
	
}
