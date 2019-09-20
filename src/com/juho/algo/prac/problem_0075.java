package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits 
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
 * to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and 
 * this string can be deserialized to the original tree structure.
 * 
 * Note: Do not use class member/global/static variables to store states. 
 * Your serialize and deserialize algorithms should be stateless.
 * 
 * @author Juho Lee
 * @since Sep 20, 2019
 */
public class problem_0075 {

	/**
	 * Used BFS to serialize TreeNode
	 * 
	 * @param root
	 * @return String
	 */
    public String serializeBFS(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.offer(node.left);
                sb.append(node.left.val).append(",");
            }
            else sb.append("null").append(",");
            if(node.right != null) {
                queue.offer(node.right);
                sb.append(node.right.val).append(",");
            }
            else sb.append("null").append(",");
        }
        return sb.toString();
    }

    /**
     * Used BFS to deserialize String
     * 
     * @param data
     * @return TreeNode
     */
    public TreeNode deserializeBFS(String data) {
        if(data.length() == 0) return null;
        int i = 1;
        String[] tree = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(tree[0]));
        queue.offer(root);
        while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (tree[i].equals("null")) node.left = null;
			else {
				node.left = new TreeNode(Integer.valueOf(tree[i]));
				queue.offer(node.left);
			}
            i++;
			if (tree[i].equals("null")) node.right = null;
			else {
				node.right = new TreeNode(Integer.valueOf(tree[i]));
				queue.offer(node.right);
			}
            i++;
        }
        return root;
    }
	
    /**
     * Used preorder traversal to serialize TreeNode
     * 
     * @param root
     * @return String
     */
	public String serialize(TreeNode root) {
		StringBuilder serializedTree = new StringBuilder();
		serialize(root, serializedTree);
		return serializedTree.toString();
	}
	
	private void serialize(TreeNode root, StringBuilder sb) {
		if(root == null) sb.append(".").append(" ");
		else {
			sb.append(root.val).append(" ");
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}
	
	/**
	 * Used preorder traversal to deserialize String
	 * 
	 * @param data
	 * @return TreeNode
	 */
	public TreeNode deserialize(String data) {
		return deserialize(new ArrayList<>(Arrays.asList(data.trim().split(" "))));
	}
	
	private TreeNode deserialize(List<String> list) {
		if(list.isEmpty() || list.get(0).equals(".")) {
            list.remove(0);
            return null;
        }
		TreeNode root = new TreeNode(Integer.valueOf(list.remove(0)));
		root.left = deserialize(list);
		root.right = deserialize(list);
		return root;
	}
	
}
