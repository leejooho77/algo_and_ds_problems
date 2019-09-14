package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted list of numbers, return a list of strings that represent all of the consecutive numbers.
 * 
 * Example:
 * Input: [0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15], Output: ['0->2', '5->5', '7->11', '15->15']
 * 
 * Assume that all numbers will be greater than or equal to 0, and each element can repeat.
 * 
 * @author Juho Lee
 * @since Sep 14, 2019
 */
public class problem_0063 {

	public List<String> findRanges(int[] nums) {
		int start = -1, end = -1;
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= nums.length; i++) {
			// if i is equal to 0, set start and end to current value
			if(i == 0) {
				start = nums[i];
				end = nums[i];
			} 
			// if we reach at the end of the nums, we need to insert last range into result
			else if(i == nums.length) {
				result.add(sb.append(start).append("->").append(end).toString());
			}
			else {
				// if it is duplicate or consecutive, just update end
				if(nums[i] - nums[i - 1] <= 1)
					end = nums[i];
				// else we insert previous range into result
				// and set start and end to current value
				else {
					result.add(sb.append(start).append("->").append(end).toString());
					sb = new StringBuilder();
					start = nums[i];
					end = nums[i];
				}
			}
		}
		return result;
	}
	
}
