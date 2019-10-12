package com.juho.algo.prac;

/**
 * You are given an array of integers, and an integer K. 
 * Return the range of index which sums to K. You can assume that a solution will always exist.
 * 
 * Example 1:
 * Input:nums = [1,3,2,5,7,2], k = 14, Output: [2,4]
 * 
 * Can you do this in linear time?
 * 
 * @author Juho Lee
 * @since Oct 12, 2019
 */
public class problem_0107 {

	public int[] subarraySum(int[] nums, int k) {
		int left = 0, right = 0, sum = 0;
		for(; right < nums.length; right++) {
			sum += nums[right];
			while(sum > k) {
				sum -= nums[left++];
			}
			if(sum == k) {
				return new int[] {left, right};
			}
		}
		return new int[] {0, 0};
	}
	
}
