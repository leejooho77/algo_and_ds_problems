package com.juho.algo.prac;

/**
 * Given a list of numbers, where every number shows up twice except for one number, find that one number.
 * 
 * Example:
 * Input: [4, 3, 2, 4, 1, 3, 2], Output: 1
 * 
 * @author Juho Lee
 * @since July 26, 2019
 */
public class problem_0009 {
	
	public int singleNumber(int[] nums) {
		int result = 0;
		for(int i : nums) result ^= i;
		return result;
	}

}
