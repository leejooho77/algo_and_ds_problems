package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * Example 1:
 * Input: [0,1,0,null,null,1,0,1,1,null,null], Output: 5
 * 
 * @author Juho Lee
 * @since Sep 02, 2019
 */
public class problem_0047 {
	
	int count = 0;
	
	public int countUnivalSubtreesWithGlobalValue(TreeNode root) {
		isUnivalTree(root);
		return count;
	}
	
	public boolean isUnivalTree(TreeNode root) {
		if(root == null) return true;
		if(root.left == null && root.right == null) {
			count++;
			return true;
		}
		boolean left = isUnivalTree(root.left);
		boolean right = isUnivalTree(root.right);
		if(!left || !right) return false;
		if((root.left != null && root.left.val != root.val) ||
			(root.right != null && root.right.val != root.val))
			return false;
		else {
			count++;
			return true;
		}
	}
	
	public class Status {
		boolean isUnival;
		int count;
		public Status(boolean isUnival, int count) {
			this.isUnival = isUnival;
			this.count = count;
		}
	}
	
	public int countUnivalSubtrees(TreeNode root) {
		return countUnivalSubtreesHelper(root).count;
	}
	
	public Status countUnivalSubtreesHelper(TreeNode root) {
		if(root == null) return new Status(true, 0);
		else if(root.left == null && root.right == null) return new Status(true, 1);
		Status left = countUnivalSubtreesHelper(root.left);
		Status right = countUnivalSubtreesHelper(root.right);
		if(!left.isUnival || !right.isUnival) return new Status(false, left.count + right.count);
		else if((root.left != null && root.left.val != root.val) || (root.right != null && root.right.val != root.val))
			return new Status(false, left.count + right.count);
		else 
			return new Status(true, left.count + right.count + 1);
	}
	
}
