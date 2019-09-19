package com.juho.algo.prac;

/**
 * You are given a binary tree representation of an arithmetic expression. 
 * In this tree, each leaf is an integer value,, and a non-leaf node is one of the four operations: 
 * '+', '-', '*', or '/'.
 * 
 * Write a function that takes this tree and evaluates the expression.
 * 
 * Example:
 * 		  *
 * 	    /   \
 * 	   +     +
 *    / \   / \
 *   3   2 4   5
 *   
 * This is a representation of the expression (3 + 2) * (4 + 5), and should return 45.
 * 
 * @author Juho Lee
 * @since Sep 19, 2019
 */
public class problem_0074 {
	
	private final String PLUS = "+";
	private final String MINUS = "-";
	private final String MULTIPLY = "*";
	private final String DIVISION = "/";
	
	public static class ArithmeticTreeNode {
		ArithmeticTreeNode left;
		ArithmeticTreeNode right;
		String ops;
		
		public ArithmeticTreeNode(String ops) {
			this.ops = ops;
		}
		
	}

	public int calculate(ArithmeticTreeNode root) {
		// Leaf node cannot be an operator
		if(root.left == null && root.right == null && isOperator(root.ops))
			throw new ArithmeticException("[ERROR]: Expected number, but operator found");
		// If leaf node is number, return it as integer
		else if(root.left == null && root.right == null)
			return Integer.valueOf(root.ops);
		// Get left value
		int left = calculate(root.left);
		// Get right value
		int right = calculate(root.right);
		// If parent node is not operator, throw error
		if(!isOperator(root.ops))
			throw new ArithmeticException("[ERROR]: Expected operator, but number found");
		// Calculate left and right based on the operator
		if(root.ops.equals(PLUS))
			return left + right;
		else if(root.ops.equals(MINUS))
			return left - right;
		else if(root.ops.equals(MULTIPLY))
			return left * right;
		else
			return left / right;
	}
	
	private boolean isOperator(String s) {
		return s.equals(PLUS) || s.equals(MINUS) || s.equals(MULTIPLY) || s.equals(DIVISION);
	}
	
}
