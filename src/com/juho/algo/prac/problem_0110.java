package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * @author Juho Lee
 * @since Oct 14, 2019
 */
public class problem_0110 {

	public List<List<Integer>> levelOrderWithRecursion(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		levelOrder(root, result, 1);
		return result;
	}
	
	public void levelOrder(TreeNode root, List<List<Integer>> result, int level) {
		if(root == null)
			return;
		if(result.size() < level) {
			result.add(new ArrayList<>());
		}
		result.get(level - 1).add(root.val);
		if(root.left != null) levelOrder(root.left, result, level + 1);
		if(root.right != null) levelOrder(root.right, result, level + 1);
	}
	
	public List<List<Integer>> levelOrderWithQueue(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
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
			result.add(level);
		}
		return result;
	}
	
}
