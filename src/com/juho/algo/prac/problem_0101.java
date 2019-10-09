package com.juho.algo.prac;

/**
 * Given a sorted list of positive numbers, find the smallest positive number that cannot be a sum of any subset in the list.
 * 
 * Example:
 * Input: [1, 2, 3, 8, 9, 10], Output: 7
 * Explanation: Numbers 1 to 6 can all be summed by a subset of the list of numbers, but 7 cannot.
 * 
 * @author Juho Lee
 * @since Oct 8, 2019
 */
public class problem_0101 {

	public int findSmallest(int[] nums) {
		int max = 0;
		for(int i = 0; i < nums.length; i++) {
			// if current value is smaller than or equal to current max+1
			// add current value to max
			if(nums[i] <= max + 1) 
				max += nums[i];
		}
		return max + 1;
	}
	
}
