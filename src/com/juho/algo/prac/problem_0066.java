package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 		1
 * 	   / \
 * 	  2   5
 *   / \   \
 *  3   4   6
 *  
 *  The flattened tree should look like:
 *  	1
 *       \
 *        2
 *         \
 *          3
 *           \
 *            4
 *             \
 *              5
 *               \ 
 *                6 
 * 
 * @author Juho Lee
 * @since Sep 15, 2019
 */
public class problem_0066 {

	/**
	 * If current root is null, end the recursion
	 * If we have left nodes in current root, insert it between root and its right.
	 * Else do nothing, proceed recursion
	 * 
	 * @param root
	 */
	public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            TreeNode curr = root;
            TreeNode mid = root.left;
            TreeNode end = root.right;
            root.right = mid;
            root.left = null;
            while(curr.right != null) {
                curr = curr.right;
            }
            curr.right = end;
        }
        flatten(root.right);
    }
	
}
