package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * @author leejooho77
 * @since Oct 1, 2019
 */
public class problem_0090 {

	public List<Integer> preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(!stack.empty() || root != null) {
            while(root != null) {
                stack.push(root);
                result.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }
	
	public List<Integer> preorderTraversalRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<>();
        if(root == null) return result;
		result.add(root.val);
		result.addAll(preorderTraversalRecursive(root.left));
		result.addAll(preorderTraversalRecursive(root.right));
		return result;
	}
	
}
