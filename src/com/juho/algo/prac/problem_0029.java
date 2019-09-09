package com.juho.algo.prac;

/**
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * Input: [0,1,0,3,12], Output: [1,3,12,0,0]
 * 
 * @author Juho Lee
 * @since Aug 15, 2019
 */
public class problem_0029 {

	public void moveZeroes(int[] nums) {
		int write = 0, read = 0;
		while(read < nums.length) {
			if(nums[read] != 0) {
				if(read != write) {
					nums[write] = nums[read];
					nums[read] = 0;
				}
				write++;
			}
			read++;
		}
	}
	
}
