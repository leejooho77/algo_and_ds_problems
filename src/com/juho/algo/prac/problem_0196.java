package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree and an integer k, filter the binary tree such that its leaves don't contain the value k. Here are the rules:
 *
 * - If a leaf node has a value of k, remove it.
 * - If a parent node has a value of k, and all of its children are removed, remove it.
 *
 * @author Juho Lee
 * @since Nov 29, 2019
 */
public class problem_0196 {

    public TreeNode filter(TreeNode root, int k) {
        remove(root, k);
        return root;
    }

    private boolean remove(TreeNode root, int k) {
        if(root == null)
            return true;
        boolean leftFilter = remove(root.left, k);
        boolean rightFilter = remove(root.right, k);
        if(leftFilter) root.left = null;
        if(rightFilter) root.right = null;
        if(root.val != k) return false;
        return leftFilter && rightFilter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(1);
        System.out.println(root.toString());
        System.out.println(new problem_0196().filter(root, 1).toString());

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(root1.toString());
    }

}