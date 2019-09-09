package com.juho.algo.prac;

/**
 * You have a landscape, in which puddles can form. 
 * You are given an array of non-negative integers representing the elevation at each location. 
 * Return the amount of water that would accumulate if it rains.
 * 
 * For example: [0,1,0,2,1,0,1,3,2,1,2,1] should return 6 because 6 units of water can get trapped here.
 * 
 * @author Juho Lee
 * @since Aug 25, 2019
 */
public class problem_0039 {
	
	public int trap(int[] height) {
		int amount = 0, start = 0, end = height.length - 1, maxLeft = 0, maxRight = 0;
		while(start <= end) {
			if(maxLeft <= maxRight) {
				maxLeft = Math.max(maxLeft, height[start]);
				amount += maxLeft - height[start];
				start++;
			} else {
				maxRight = Math.max(maxRight, height[end]);
				amount += maxRight - height[end];
				end--;
			}
		}
		return amount;
	}

}
