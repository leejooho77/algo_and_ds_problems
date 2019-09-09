package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * @author Juho Lee
 * @since Aug 30, 2019
 */
public class problem_0044 {
	
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}
	
	public boolean isValidBST(TreeNode root, TreeNode left, TreeNode right) {
		if(root == null) return true;
		if(left != null && root.val <= left.val) return false;
		if(right != null && root.val >= right.val) return false;
		return isValidBST(root.left, left, root) && isValidBST(root.right, root, right);
	}

}
