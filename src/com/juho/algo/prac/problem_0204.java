package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * @author Juho Lee
 * @since Dec 5, 2019
 */
public class problem_0204 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return root;
        TreeNode parent = null;
        TreeNode child = root;
        while(child != null && child != p) {
            // change parent only if we go to left
            if(child.val > p.val) {
                parent = child;
                child = child.left;
            }
            else
                child = child.right;
        }
        // if we don't find p
        if(child == null)
            return child;
        // if p has right child
        if(child.right != null) {
            child = child.right;
            while(child.left != null)
                child = child.left;
            return child;
        }
        return parent;
    }

}