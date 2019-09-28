package com.juho.algo.prac;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * Input: [2,3,1,1,4], Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * 		        Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note: You can assume that you can always reach the last index.
 * 
 * @author Juho Lee
 * @since Sep 28, 2019
 */
public class problem_0085 {

	public int jump_bruteforce(int[] nums) {
		// if we have 0 or 1 element in array, return 0
		if(nums.length <= 1) return 0;
		// set min to length of the array
        int min = nums.length;
        // create array to store current least jumps
		int[] jumps = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
				// we want to go as far as we want to get least jumps, 
				// so if we can reach with same jumps, proceed as far as we can
                if(jumps[j] != 0 && jumps[j] == jumps[i]) continue;
                jumps[j] = jumps[i] + 1;
                // if we reach at the end, get min of the jumps
				if(j == nums.length - 1)
					min = Math.min(min, jumps[j]);
			}
		}
        return min;
    }
	
	public int jump_optimized(int[] nums) {
		int count = 0, end = 0, farthest = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			// keep track of farthest jump
			farthest = Math.max(farthest, i + nums[i]);
			// if we reached current end point, increment count and update the end point to farthest
			if(i == end) {
				count++;
				end = farthest;
			}
		}
		return count;
    }
	
}
