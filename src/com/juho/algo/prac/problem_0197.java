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
        findLeaves(result, root, 0);
        return result;
    }

    private int findLeaves(List<List<Integer>> result, TreeNode root, int i) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null && result.size() == i) {
            result.add(new ArrayList<>());
            result.get(i).add(root.val);
            return i;
        }
        int index = Math.max(findLeaves(result, root.left, i), findLeaves(result, root.right, i));
        if(result.size() == index)
            result.add(new ArrayList<>());
        result.get(index).add(root.val);
        return index + 1;
    }

}