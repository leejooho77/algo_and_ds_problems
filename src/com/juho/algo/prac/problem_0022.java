package com.juho.algo.prac;

/**
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.
 * 
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3], Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * @author leejooho77
 * @since Aug 07, 2019
 */
public class problem_0022 {

	public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= s) {
                sum -= nums[left];
                min = Math.min(min, right - left + 1);
                left++;
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
	
}
