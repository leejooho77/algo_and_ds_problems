package com.juho.algo.prac;

/**
 * Given a list of numbers of size n, where n is greater than 3, 
 * find the maximum and minimum of the list using less than 2 * (n - 1) comparisons.
 * 
 * @author Juho Lee
 * @since Oct 1, 2019
 */
public class problem_0089 {

	/**
	 * Worst case: 2(n - 1)
	 * Best case: n - 1
	 * Average: 1.5(n - 1)
	 * 
	 * @param nums
	 * @return int[]
	 */
	public int[] findMinAndMax(int[] nums) {
		int min = nums[0], max = min;
		for(int i : nums) {
			if(i > max) max = i;
			else if(i < min) min = i;
		}
		return new int[] {min, max};
	}
	
}
