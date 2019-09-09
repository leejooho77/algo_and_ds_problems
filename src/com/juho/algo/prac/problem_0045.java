package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given a binary tree, return all values given a certain height h.
 * 
 * @author Juho Lee
 * @since Aug 31, 2019
 */
public class problem_0045 {
	
	public List<Integer> valuesAtHeight(TreeNode root, int height) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		int count = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty() && count <= height) {
			int size = queue.size();
			while(size-- > 0) {
				TreeNode node = queue.poll();
				if(count == height) result.add(node.val);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			count++;
		}
		return result;
	}

}
