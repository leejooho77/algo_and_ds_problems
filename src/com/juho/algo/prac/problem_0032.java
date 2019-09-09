package com.juho.algo.prac;

/**
 * You are given an array of integers. 
 * Return the largest product that can be made by multiplying any 3 integers in the array.
 * 
 * Example:
 * [-4, -4, 2, 8] should return 128 as the largest product can be made by multiplying -4 * -4 * 8 = 128.
 * 
 * @author leejooho77
 * @since Aug 18, 2019
 */
public class problem_0032 {

	public int maximumProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for(int i : nums) {
			if(i > max1) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			} else if(i > max2) {
                max3 = max2;
				max2 = i;
            } else if(i > max3) {
                max3 = i;
            } if(i < min1) {
				min2 = min1;
				min1 = i;
			} else if(i < min2) {
                min2 = i;
            }
		}
		return Math.max(max1 * min1 * min2, max1 * max2 * max3);  
	}
	
}
