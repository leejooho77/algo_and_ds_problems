package com.juho.algo.prac;

import java.util.Stack;

/**
 * Given a mathematical expression with just 
 * single digits, plus signs, negative signs, and brackets, evaluate the expression. 
 * Assume the expression is properly formed.
 * 
 * Example:
 * Input: - ( 3 + ( 2 - 1 ) ), Output: -4
 * 
 * @author leejooho77
 * @since Aug 05, 2019
 */
public class problem_0019 {
	
	public int calculate(String s) {
		int result = 0, sign = 1;
		Stack<Integer> stack = new Stack<>();
		s = s.trim();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ') continue;
			else if(Character.isDigit(c)) {
				int val = c - '0';
				while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					val = val * 10 + (s.charAt(i + 1) - '0');
					i++;
				}
				result += (sign * val);
			} else if(c == '+')
				sign = 1;
			else if(c == '-') 
				sign = -1;
			else if(c == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else {
				result = result * stack.pop() + stack.pop();
			}
		}
		return result;
	}

}
