package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *  - The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 *  - The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 *  - Both the left and right subtrees must also be binary search trees.
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 *
 * @author Juho Lee
 * @since Nov 19, 2019
 */
public class problem_0174 {

    Integer prev = null;
    int count;
    int max = 1;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        findMode(root, modes);
        return modes.stream().mapToInt(n -> n).toArray();
    }

    public void findMode(TreeNode root, List<Integer> modes) {
        if(root == null)
            return;
        findMode(root.left, modes);
        if(prev == null || prev != root.val) {
            prev = root.val;
            count = 1;
            if(max == count)
                modes.add(root.val);
        } else {
            count++;
            if(count >= max) {
                if(count > max) {
                    max = count;
                    modes.clear();
                }
                modes.add(root.val);
            }
        }
        findMode(root.right, modes);
    }

}