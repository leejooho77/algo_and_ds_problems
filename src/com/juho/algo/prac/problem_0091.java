package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * @author Juho Lee
 * @since Oct 1, 2019
 */
public class problem_0091 {
	
	public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(!stack.empty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

	public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.addAll(inorderTraversalRecursive(root.left));
        result.add(root.val);
        result.addAll(inorderTraversalRecursive(root.right));
        return result;
    }
	
}
