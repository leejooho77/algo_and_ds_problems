package com.juho.algo.prac;

import java.util.Stack;

/**
 * There are n people lined up, and each have a height represented as an integer. 
 * A murder has happened right in front of them, and only people who are taller than everyone in front of them are able to see what has happened. 
 * How many witnesses are there?
 * 
 * Example:
 * Input: [3, 6, 3, 4, 1]  , Output: 3
 * Explanation: Only [6, 4, 1] were able to see in front of them.
 * 
 * @author leejooho77
 * @since Aug 13, 2019
 */
public class problem_0027 {

	public int witness(int[] people) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < people.length; i++) {
			while(!stack.empty() && people[i] > stack.peek()) {
				stack.pop();
			}
			stack.push(people[i]);
		}
		return stack.size();
	}
	
}
