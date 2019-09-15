package com.juho.algo.prac;

/**
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Example:
 * Input:  [1,2,3,4], Output: [24,12,8,6]
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * @author Juho Lee
 * @since Sep 15, 2019
 */
public class problem_0067 {

	/**
	 * First, start with index 0, get the product of elements and set as the value of index i + 1.
	 * Second, start with end of index, get the product of elements and set as the value of index i - 1.
	 * 
	 * @param nums
	 * @return int[]
	 */
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
		int prod = 1;
		for(int i = 0; i < nums.length - 1; i++) {
			prod *= nums[i];
			result[i + 1] = prod;
		}
		prod = 1;
		for(int i = nums.length - 2; i >= 0; i--) {
			prod *= nums[i + 1];
			result[i] = (i == 0) ? prod : result[i] * prod;
		}
		return result;
    }
	
}
