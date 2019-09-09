package com.juho.algo.prac;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * Given an array with n objects colored red, white or blue, 
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Example:
 * Input: [2,0,2,1,1,0], Output: [0,0,1,1,2,2]
 * 
 * @author Juho Lee
 * @since Sep 04, 2019
 */
public class problem_0049 {

	public void sortColor(int[] nums) {
		int red = 0, blue = nums.length - 1;
		for(int i = 0; i < nums.length; i++) {
			if(i != red && nums[i] == 0) {
				ArrayUtils.swap(nums, i--, red++);
			} else if(i < blue && nums[i] == 2) {
				ArrayUtils.swap(nums, i--, blue--);
			}
		}
	}
	
}
