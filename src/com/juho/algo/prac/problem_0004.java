package com.juho.algo.prac;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 
 * An input string is valid if:
 * - Open brackets are closed by the same type of brackets.
 * - Open brackets are closed in the correct order.
 * - Note that an empty string is also considered valid.
 * 
 * Example:
 * Input: "((()))", Output: True
 * Input: "[()]{}", Output: True
 * Input: "({[)]", Output: False
 * 
 * @author Juho Lee
 * @since July 21, 2019
 */
public class problem_0004 {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c == '(') stack.push(')');
			else if(c == '{') stack.push('}');
			else if(c == '[') stack.push(']');
			else if(stack.empty() || c != stack.pop()) return false;
		}
		return stack.empty();
	}
	
}
