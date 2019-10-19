package com.juho.algo.prac;

import java.util.LinkedList;
import java.util.Queue;

import com.juho.algo.prac.ds.TreeNode;

/**
 * You are given the root of a binary tree. 
 * Find the level for the binary tree with the minimum sum, and return that value.
 * 
 * @author leejooho77
 * @since Oct 17, 2019
 */
public class problem_0115 {
	
	public int minimumLevelSum(TreeNode root) {
		int min = Integer.MAX_VALUE;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(root != null && !queue.isEmpty()) {
			int sum = 0;
			int size = queue.size();
			while(size-- > 0) {
				root = queue.poll();
				sum += root.val;
				if(root.left != null)
					queue.offer(root.left);
				if(root.right != null)
					queue.offer(root.right);
			}
			min = Math.min(min, sum);
		}
		return min;
	}

}
