package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: 
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants 
 * (where we allow a node to be a descendant of itself).”
 * 
 * @author Juho Lee
 * @since Oct 16, 2019
 */
public class problem_0114 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		// if we reach the leaf node or we reach to either A or B, return itself
		if(root == null || root == A || root == B) return root;
		// go to left and right to find A and B
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		// if both left and right are not null, it means it is a lowest common ancestor
		// so return itself
		if(left != null && right != null) return root;
		// else if left is not null, return left
		else if(left != null) return left;
		// else if right is not null, return right
		else if(right != null) return right;
		// else return null
		return null;
	}
	
}
