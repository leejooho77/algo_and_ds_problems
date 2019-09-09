package com.juho.algo.prac;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.
 * 
 * Example 1:
 * Input: [3, 3, 2, 1, 3, 2, 1], Output: [1, 1, 2, 2, 3, 3, 3]
 * 
 * Challenge: Try sorting the list using constant space.
 * 
 * @author Juho Lee
 * @since July 24, 2019
 */
public class problem_0007 {

	/**
	 * @param nums			array of 3 unique numbers (1, 2, 3)
	 */
	public void sort(int[] nums) {
		int i = 0, low = 0, high = nums.length - 1;
		while(i < high) {
			if(nums[i] == 3) {
				ArrayUtils.swap(nums, i, high);
				high--;
			} else if(nums[i] == 1) {
				ArrayUtils.swap(nums, i, low);
				low++;
				i++;
			} else i++;
		}
	}
}
