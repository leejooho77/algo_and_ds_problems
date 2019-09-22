package com.juho.algo.prac.sort;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * 
 * @author Juho Lee
 * @since Sep 21, 2019
 */
public class InsertionSort {
	
	public void insertionSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(nums[j] > nums[j + 1])
					ArrayUtils.swap(nums, j, j + 1);
			}
		}
	}

}
