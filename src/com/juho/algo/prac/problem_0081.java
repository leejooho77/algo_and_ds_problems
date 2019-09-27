package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, remove the nodes in which there is only 1 child, so that the binary tree is a full binary tree.
 * So leaf nodes with no children should be kept, and nodes with 2 children should be kept as well.
 * 
 * @author Juho Lee
 * @since Sep 25, 2019
 */
public class problem_0081 {

	public void fullBinaryTree(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) 
			return;
		else if(root.left != null && root.right != null) {
			fullBinaryTree(root.left);
			fullBinaryTree(root.right);
		} else if(root.left == null)
			root.left = null;
		else if(root.right == null)
			root.right = null;
	}
	
	public boolean isFull(TreeNode root) {
		if(root == null) 
			return true;
		else if(root.left == null && root.right == null) 
			return true;
		else if(root.left != null && root.right != null) 
			return isFull(root.left) && isFull(root.right);
		else return false;
	}
	
}
