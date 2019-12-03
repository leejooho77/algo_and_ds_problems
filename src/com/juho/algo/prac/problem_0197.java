package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 *
 * Input: 1
 *       / \
 *     2   3
 *   / \
 *  4   5
 * Output: [4, 5, 3], [2], [1].
 *
 * @author Juho Lee
 * @since Nov 29, 2019
 */
public class problem_0197 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        findLeaves(result, root);
        return result;
    }

    private void findLeaves(List<List<Integer>> result, TreeNode root) {

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new problem_0197().findLeaves(root));
    }

}