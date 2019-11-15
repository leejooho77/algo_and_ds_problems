package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * @author Juho Lee
 * @since Nov 15, 2019
 */
public class problem_0167 {

    public boolean isBalanced(TreeNode root) {
        return (isBalancedHelper(root) >= 0);
    }

    public int isBalancedHelper(TreeNode root) {
        if(root == null) return 0;
        int left = isBalancedHelper(root.left) + 1;
        int right = isBalancedHelper(root.right) + 1;
        if(Math.abs(left - right) > 1)
            return -999;
        else
            return Math.max(left, right);
    }

}