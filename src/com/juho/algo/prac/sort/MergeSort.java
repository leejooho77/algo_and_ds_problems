package com.juho.algo.prac.sort;

/**
 * 
 * @author Juho Lee
 * @since Sep 21, 2019
 */
public class MergeSort {

	public void mergeSort(int[] nums, int start, int end) {
		if(start >= end) return;
		int mid = start + (end - start)/2;
		mergeSort(nums, start, mid);
		mergeSort(nums, mid + 1, end);
		merge(nums, start, mid, end);
	}
	
	public void merge(int[] nums, int start, int mid, int end) {
		int[] left = new int[mid - start + 1];
		int[] right = new int[end - mid];
		int i = 0, j = 0;
		for(int k = start; k <= mid; k++) {
			left[i++] = nums[k];
		}
		for(int k = mid + 1; k <= end; k++) {
			right[j++] = nums[k];
		}
		i = 0; 
		j = 0; 
		int k = start;
		while(i < left.length || j < right.length) {
			if(i == left.length)
				nums[k++] = right[j++];
			else if(j == right.length)
				nums[k++] = left[i++];
			else if(left[i] < right[j])
				nums[k++] = left[i++];
			else
				nums[k++] = right[j++];
		}
	}
}
