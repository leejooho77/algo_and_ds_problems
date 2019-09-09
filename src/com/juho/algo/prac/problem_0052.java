package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * You are given the root of a binary tree. 
 * Find and return the largest subtree of that tree, which is a valid binary search tree.
 * 
 * @author Juho Lee
 * @since Sep 7, 2019
 */
public class problem_0052 {
	
	public class TreeNodeWrapper {
		boolean isBST;
		TreeNode min;
		TreeNode max;
		TreeNode root;
		int count;
		
		public TreeNodeWrapper(boolean isBST, TreeNode min, TreeNode max, TreeNode root, int count) {
			this.isBST = isBST;
			this.min = min;
			this.max = max;
			this.root = root;
			this.count = count;
		}
	}

	public TreeNode largestBSTSubtree(TreeNode root) {
		if(root == null) return null;
		TreeNodeWrapper wrapper = find(root);
		return wrapper.root;
    }
	
	private TreeNodeWrapper find(TreeNode root) {
		if(root == null) return null;
		TreeNodeWrapper left = find(root.left);
		TreeNodeWrapper right = find(root.right);
		// if it is leaf node
		// set min, max, and root as root itself and set count as 1
		if(left == null && right == null)
			return new TreeNodeWrapper(true, root, root, root, 1);
		// if only left is null
		if(left == null) {
			if(!right.isBST) return right;
			return new TreeNodeWrapper(true, root, right.min, root, right.count + 1);
		}
		// if only right is null
		if(right == null) {
			if(!left.isBST) return left;
			return new TreeNodeWrapper(true, left.max, root, root, left.count + 1);
		}
		// if both left and right are valid BSTs
		// check if max of left is less than root and min of right is greater than root
		// if it is
		if(left.isBST && right.isBST && left.max.val < root.val && root.val < right.min.val)
			return new TreeNodeWrapper(true, left.max, right.min, root, left.count + right.count + 1);
		// else return subtree with largest count
		return (left.count > right.count) ? left : right;
	}
	
}
