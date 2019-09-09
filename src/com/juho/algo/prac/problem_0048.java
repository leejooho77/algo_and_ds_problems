package com.juho.algo.prac;

import java.util.HashMap;
import java.util.Map;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author leejooho77
 * @since Sep 03, 2019
 */
public class problem_0048 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for(int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		return buildTree(preorder, inorder, inorderMap, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, 
			int preStart, int preEnd, int inStart, int inEnd) {
		if(preStart > preEnd || inStart > inEnd) return null;
		int rootIdx = inorderMap.get(preorder[preStart]);
		int leftSize = rootIdx - inStart;
		TreeNode root = new TreeNode(preorder[preStart]);
		root.left = buildTree(preorder, inorder, inorderMap, preStart + 1, preStart + leftSize, inStart, rootIdx - 1);
		root.right = buildTree(preorder, inorder, inorderMap, preStart + leftSize + 1, preEnd, rootIdx + 1, inEnd);
		return root;
	}
	
}
