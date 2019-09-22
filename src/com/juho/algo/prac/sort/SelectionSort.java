package com.juho.algo.prac.sort;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * 
 * @author Juho Lee
 * @since Sep 21, 2019
 */
public class SelectionSort {

	public void selectionSort(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[min] > nums[j])
					min = j;
			}
			ArrayUtils.swap(nums, i, min);
		}
	}
	
}
