package com.juho.algo.prac;

/**
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * 
 * Example 1:
 * Input: [4,2,3], Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * 
 * Example 2:
 * Input: [4,2,1], Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * 
 * Note: The n belongs to [1, 10,000].
 * 
 * @author Juho Lee
 * @since Sep 22, 2019
 */
public class problem_0078 {

	/**
	 * Basically, first approach would be counting the decreasing contiguous two values.
	 * If count is greater than 1, then we cannot make it to non-decreasing array by modify at most one element.
	 * Additionally, if the count is 1, there is an exception: [3,4,2,3]
	 * 
	 * So, for this case, we need to set some condition which would be:
	 *  1. value at i should not be greater than value at i+2.
	 *  2. value at i-1 should not be greater than value at i+1.
	 *  
	 * By checking this condition, we can ensure that this array can be non-decreasing array by modify at most one element.
	 * 
	 * @param nums
	 * @return boolean
	 */
	public boolean checkPossibility(int[] nums) {
		int count = 0;
        if(nums.length < 3) return true;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                if(i > 0 && i + 2 < nums.length && nums[i] > nums[i + 2] && nums[i - 1] > nums[i + 1])
                    return false;
                count++;
            }
        }
        return (count <= 1);
	}
	
}
