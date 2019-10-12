package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree 
 * along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * 
 * Example:
 * Input: [-10,9,20,null,null,15,7], Output: 42
 * 
 * 				-10
 * 				/ \
 * 			   9 [20]
 * 			     /  \
 *             [15] [7]
 * 
 * @author Juho Lee
 * @since Oct 9, 2019
 */
public class problem_0102 {
	
	// global variable to track the max
	int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }
	
	private int getMax(TreeNode root) {
        if(root == null) 
            return 0;
        // if left is less than 0, get 0
        // else get max path of left
        int left = Math.max(getMax(root.left), 0);
        // if right is less than 0, get 0
        // else get max path of right
        int right = Math.max(getMax(root.right), 0);
        // update the max
        max = Math.max(max, left + right + root.val);
        // return current max path
		return Math.max(left, right) + root.val;
	}

}
