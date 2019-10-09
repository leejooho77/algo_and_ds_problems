package com.juho.algo.prac;

import java.util.PriorityQueue;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * Example 1:
 * Input: [10,2], Output: "210"
 * 
 * Example 2:
 * Input: [3,30,34,5,9], Output: "9534330"
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * @author Juho Lee
 * @since Oct 7, 2019
 */
public class problem_0100 {

	public String largestNumber(int[] nums) {
		PriorityQueue<String> queue = new PriorityQueue<String>((a, b) -> {
			/**
			 * custom comparator for heap
			 * ex) [31, 9]
			 * 	 - ab = 319
			 *   - ba = 913
			 *   => ba is larger, so 9 will be top of the heap
			 */
			String ab = a + b;
			String ba = b + a;
			return ba.compareTo(ab);
		});
		for(int i : nums) queue.add(String.valueOf(i));
		// check if the number is 0 or not
		if(queue.peek().equals("0")) return queue.remove();
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) sb.append(queue.remove());
		return sb.toString();
    }

}
