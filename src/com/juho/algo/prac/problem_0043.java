package com.juho.algo.prac;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 * Input: [1,2,0], Output: 3
 * 
 * Example 2:
 * Input: [3,4,-1,1], Output: 2
 * 
 * Example 3:
 * Input: [7,8,9,11,12], Output: 1
 * 
 * @author Juho Lee
 * @since Aug 29, 2019
 */
public class problem_0043 {

	public int firstMissingPositive(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			// should be range of 1 to length of nums
			// if we have duplicate value in correct place, skip
			if(nums[i] > 0 && nums[i] - 1 < nums.length && 
               i + 1 != nums[i] && nums[nums[i] - 1] != nums[i]) {
				ArrayUtils.swap(nums, i, nums[i] - 1);
				i--;
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(i + 1 != nums[i]) 
				return i + 1;
		}
		return nums.length + 1;
	}
	
}
