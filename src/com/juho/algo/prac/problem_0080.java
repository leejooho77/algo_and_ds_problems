package com.juho.algo.prac;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *  - push(x) -- Push element x onto stack.
 *  - pop() -- Removes the element on top of the stack.
 *  - top() -- Get the top element.
 *  - getMin() -- Retrieve the minimum element in the stack.
 * 
 * @author Juho Lee
 * @since Sep 24, 2019
 */
public class problem_0080 {
	
	public class MinStack {
		
		Stack<Integer> stack;
		int min;
		
		public MinStack() {
			stack = new Stack<>();
			min = Integer.MAX_VALUE;
		}
		
		public void push(int x) {
			if(x <= min) {
				stack.push(min);
				min = x;
			}
			stack.push(x);
		}
		
		public void pop() {
			if(stack.pop() == min)
				min = stack.pop();
		}
		
		public int top() {
			return stack.peek();
		}
		
		public int getMin() {
			return min;
		}
		
	}
	
}
