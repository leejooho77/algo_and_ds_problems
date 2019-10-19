package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers of size n, where all elements are between 1 and n inclusive, 
 * find all of the elements of [1, n] that do not appear in the array. Some numbers may appear more than once.
 * 
 * Example:
 * Input: [4,5,2,6,8,2,1,5], Output: [3,7]
 * 
 * @author Juho Lee
 * @since Oct 18, 2019
 */
public class problem_0116 {
	
	public List<Integer> missingNumbers(int[] nums) {
		boolean[] seen = new boolean[nums.length];
		List<Integer> result = new ArrayList<>();
		for(int i : nums) {
			if(!seen[i - 1])
				seen[i - 1] = true;
		}
		for(int i = 0; i < seen.length; i++) {
			if(!seen[i])
				result.add(i + 1);
		}
		return result;
	}
	
}
