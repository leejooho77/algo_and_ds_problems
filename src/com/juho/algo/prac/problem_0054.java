package com.juho.algo.prac;

import java.util.Stack;

/**
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', 
 * and in any positions ) so that the resulting parentheses string is valid.
 * 
 * Formally, a parentheses string is valid if and only if:
 *  - It is the empty string, or
 *  - It can be written as AB (A concatenated with B), where A and B are valid strings, or
 *  - It can be written as (A), where A is a valid string.
 *  
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * 
 * Example 1:
 * Input: "()))((", Output: 4
 * 
 * @author Juho Lee
 * @since Sep 09, 2019
 */
public class problem_0054 {
	
	/**
	 * With stack, check if parenthesis is balanced.
	 * If not, increase the counter and continue.
	 * At the end, if there are open parenthesis in stack,
	 * add to the counter.
	 * 
	 * @param S
	 * @return int
	 */
	public int minAddToMakeValidWithStack(String S) {
		int count = 0;
		Stack<Character> stack = new Stack<>();
		for(char c : S.toCharArray()) {
			if(c == '(') stack.push(')');
			else {
				if(stack.empty()) {
					count++;
				} else 
					stack.pop();
			}
		}
        return count + stack.size();
    }
	
	/**
	 * Track numbers of open and close parenthesis.
	 * If we meet open parenthesis, increment open.
	 * If we meet close parenthesis and open is 0, then increment close.
	 * Otherwise, decrement open.
	 * 
	 * @param S
	 * @return int
	 */
	public int minAddToMakeValidWithoutStack(String S) {
		int open = 0, close = 0;
		for(char c : S.toCharArray()) {
			if(c == '(')
				open++;
			else {
				if(open > 0) 
					open--;
				else
					close++;
			}
		}
		return open + close;
	}
	
}