package com.juho.algo.prac.ds;

public class TreeNode {
	
	public TreeNode left;
	public TreeNode right;
	public int val;

	public TreeNode(int val) {
		this.val  = val;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Inorder: ");
		inorderTraversal(sb, this);
		sb.append("\n").append("Preorder: ");
		preorderTraversal(sb, this);
		sb.append("\n").append("Postorder: ");
		postorderTraversal(sb, this);
		return sb.toString();
	}

	private void inorderTraversal(StringBuilder sb, TreeNode root) {
		if(root == null)
			return;
		inorderTraversal(sb, root.left);
		sb.append(root.val).append(" ");
		inorderTraversal(sb, root.right);
	}

	private void preorderTraversal(StringBuilder sb, TreeNode root) {
		if(root == null)
			return;
		sb.append(root.val).append(" ");
		inorderTraversal(sb, root.left);
		inorderTraversal(sb, root.right);
	}

	private void postorderTraversal(StringBuilder sb, TreeNode root) {
		if(root == null)
			return;
		inorderTraversal(sb, root.left);
		inorderTraversal(sb, root.right);
		sb.append(root.val).append(" ");
	}
}
