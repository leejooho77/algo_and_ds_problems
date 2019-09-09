package com.juho.algo.prac;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *  - push(x) -- Push element x to the back of queue.
 *  - pop() -- Removes the element from in front of queue.
 *  - peek() -- Get the front element.
 *  - empty() -- Return whether the queue is empty.
 * 
 * @author leejooho77
 * @since Aug 21, 2019
 */
public class problem_0035 {
	
	public class Queue {
		
		Stack<Integer> enque;
		Stack<Integer> deque;
		
		public Queue() {
			enque = new Stack<>();
			deque = new Stack<>();
		}
		
		public void push(int x) {
			enque.push(x);
		}
		
		public int pop() {
			if(empty()) return -1;
			transfer();
			return deque.pop();
		}
		
		public int peek() {
			if(empty()) return -1;
			transfer();
			return deque.peek();
		}
		
		public boolean empty() {
			return (enque.empty() && deque.empty());
		}
		
		private void transfer() {
			if(deque.empty()) {
				while(!enque.empty()) {
					deque.push(enque.pop());
				}
			}
		}
		
	}

}
