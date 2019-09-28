package com.juho.algo.prac;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * Input: [2,3,1,1,4], Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * Input: [3,2,1,0,4], Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * 
 * @author Juho Lee
 * @since Sep 28, 2019
 */
public class problem_0084 {

	public boolean canJump(int[] nums) {
		int maxDist = 0;
        for(int i = 0; i < nums.length; i++) {
        	// if previous max jump was less than current index, return false
            if(maxDist < i) return false;
            // update max jump
            maxDist = Math.max(maxDist, nums[i] + i);
        }
        return true;
	}
	
}
