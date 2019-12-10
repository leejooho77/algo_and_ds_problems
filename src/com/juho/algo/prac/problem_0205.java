package com.juho.algo.prac;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 * You will have direct access to the node but not to the root of the tree.
 * Each node will have a reference to its parent node.
 *
 * @author Juho Lee
 * @since Dec 5, 2019
 */
public class problem_0205 {

    public class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
    }

    public TreeNode inorderSuccessor(TreeNode node) {
        if(node == null)
            return node;
        // if node has right child
        if(node.right != null) {
            node = node.right;
            while(node.left != null)
                node = node.left;
            return node;
        }

        while(node.parent != null) {
            if(node.parent.right != node)
                return node.parent;
            node = node.parent;
        }
        return null;
    }

}