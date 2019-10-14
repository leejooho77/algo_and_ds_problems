package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * 
 * @author Juho Lee
 * @since Oct 14, 2019
 */
public class problem_0111 {
	
	public List<List<Integer>> levelOrderBottomWithQueue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while(root != null && !queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(0, level);
        }
        return result;
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		levelOrderBottom(root, result, 1);
		return result;
	}
	
	public void levelOrderBottom(TreeNode root, List<List<Integer>> result, int level) {
		if(root == null)
			return;
		if(result.size() < level) {
			result.add(0, new ArrayList<>());
        }
		if(root.left != null) levelOrderBottom(root.left, result, level + 1);
		if(root.right != null) levelOrderBottom(root.right, result, level + 1);
        List<Integer> list = result.get(result.size() - level);
        list.add(root.val);
	}
	
}
