package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
 * A node is deepest if it has the largest depth possible among any node in the entire tree.
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
 *
 * @author Juho Lee
 * @since Dec 12 2019
 */
public class problem_0212 {

    public class TreeNodeWithDepth {
        TreeNode node;
        int depth;
        public TreeNodeWithDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return find(root).node;
    }

    private TreeNodeWithDepth find(TreeNode root) {
        if(root == null)
            return new TreeNodeWithDepth(null, 0);
        TreeNodeWithDepth left = find(root.left);
        TreeNodeWithDepth right = find(root.right);
        if(left.depth > right.depth)
            return new TreeNodeWithDepth(left.node, left.depth + 1);
        else if(left.depth < right.depth)
            return new TreeNodeWithDepth(right.node, right.depth + 1);
        else
            return new TreeNodeWithDepth(root, left.depth + 1);
    }

}