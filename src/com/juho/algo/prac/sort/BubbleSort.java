package com.juho.algo.prac.sort;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * 
 * @author Juho Lee
 * @since Sep 21, 2019
 */
public class BubbleSort {

	public void bubbleSort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = 1; j < nums.length; j++) {
				if(nums[j - 1] > nums[j])
					ArrayUtils.swap(nums, j - 1, j);
			}
		}
	}
	
}
