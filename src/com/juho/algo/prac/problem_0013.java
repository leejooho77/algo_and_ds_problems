package com.juho.algo.prac;

import java.util.Stack;

/**
 * Implement a class for a stack that supports 
 *  - void push(int val)
 *  - int pop()
 *  - int max()
 *  
 *  Each method should run in constant time.
 * 
 * @author Juho Lee
 * @since Jul 30, 2019
 */
public class problem_0013 {

	public class MaxStack {
		int max;
		Stack<Integer> stack;
		
		public MaxStack() {
			this.max = Integer.MIN_VALUE;
			stack = new Stack<>();
		}
		
		public void push(int val) {
			if(val > this.max) {
				this.stack.push(this.max);
			}
			this.max = val;
			this.stack.push(val);
		}
		
		public int pop() {
			int val = stack.pop();
			if(val == this.max) 
				this.max = stack.pop();
			return val;
		}
		
		public int max() {
			return this.max;
		}
		
 	}
	
}
