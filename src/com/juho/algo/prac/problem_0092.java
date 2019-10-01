package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values

 * 
 * @author Juho Lee
 * @since Oct 1, 2019
 */
public class problem_0092 {
	
	public List<Integer> postorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.empty()) {
            root = stack.peek();
            if(root.left == null && root.right == null)
                result.add(stack.pop().val);
            else {
                if(root.right != null) {
                    stack.push(root.right);
                    root.right = null;
                }
                if(root.left != null) {
                    stack.push(root.left);
                    root.left = null;
                }
            }
        }
        return result;
    }

	public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.addAll(postorderTraversalRecursive(root.left));
        result.addAll(postorderTraversalRecursive(root.right));
        result.add(root.val);
        return result;
    }
	
}
