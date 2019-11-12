package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 * Input: 3, Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 *
 * Explanation:
 *
 *    1       1       2       3          3
 *     \       \     / \     /         /
 *      2       3   1   3   1        2
 *       \     /            \      /
 *        3   2              2   1
 *
 * @author Juho Lee
 * @since Nov 11, 2019
 */
public class problem_0159 {

    public List<TreeNode> generateBinaryTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateBinaryTrees(1, n);
    }

    private List<TreeNode> generateBinaryTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end) {
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateBinaryTrees(start, i - 1);
            List<TreeNode> rightTrees = generateBinaryTrees(i + 1, end);
            for(TreeNode leftTree : leftTrees) {
                for(TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }

}