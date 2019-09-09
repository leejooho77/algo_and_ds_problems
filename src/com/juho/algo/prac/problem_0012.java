package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Invert a binary tree.
 * 
 * @author Juho Lee
 * @since July 29, 2019
 */
public class problem_0012 {
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invert(root);
        return root;
    }
    
    private void invert(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
    }
    
}
