package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a Binary Search Tree (BST) with root node  root, and a target value  V, split the tree into two subtrees
 * where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.
 * It's not necessarily the case that the tree contains a node with value  V.
 *
 * Additionally, most of the structure of the original tree should remain.
 * Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.
 *
 * You should output the root TreeNode of both subtrees after splitting, in any order.
 *
 * Example 1:
 * Input: root = [4,2,6,1,3,5,7], V = 2, Output: [[2,1], [4,3,6, null, null, 5,7]]
 * Explanation: Note that root, output [0], and output [1] are TreeNode objects, not arrays.
 * The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
 *
 *          4
 *         / \
 *       2    6
 *      / \  / \
 *     1  3 5  7
 *
 * while the diagrams for the outputs are:
 *
 *          4                          2
 *         / \                       /
 *       3    6                    1
 *           / \       and
 *          5   7
 *
 * Note:
 *  - The size of the BST will not exceed 50.
 *  - The BST is always valid and each node's value is different.
 *
 * @author Juho Lee
 * @since Dec 28, 2019
 */
public class problem_0233 {

    public List<TreeNode> splitBST(TreeNode root, int V) {
        List<TreeNode> result = Arrays.asList(null, null);
        if(root == null) return result;
        else if(root.val <= V) {
            splitBST(root.right, V);
            root.right = result.get(0);
            result.remove(0);
            result.add(0, root);
        } else {
            splitBST(root.left, V);
            root.left = result.get(1);
            result.remove(1);
            result.add(1, root);
        }
        return result;
    }

}