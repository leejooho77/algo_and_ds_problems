package com.juho.algo.prac;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2, Output: 5
 * 
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4, Output: 4
 * 
 * @author leejooho77
 * @since Aug 16, 2019
 */
public class problem_0030 {

	public int findKthLargestHeap(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i < k; i++) {
			minHeap.add(nums[i]);
		}
		for(int i = k; i < nums.length; i++) {
			minHeap.add(nums[i]);
			minHeap.remove();
		}
		return minHeap.remove();
	}
	
	public int findKthLargestSort(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	
	public int findKthLargestQuickSelect(int[] nums, int k) {
		return find(nums, k, 0, nums.length - 1);
	}
	
	public int find(int[] nums, int k, int start, int end) {
		int pivot = pivot(nums, start, end);
		int count = end - pivot + 1;
		if(k == count) return nums[pivot];
		else if(k < count)
			return find(nums, k, pivot + 1, end);
		else 
			return find(nums, k - count, start, pivot - 1);
	}
	
	public int pivot(int[] nums, int start, int end) {
		int pivot = start;
		for(int i = start; i < end; i++) {
			if(nums[i] <= nums[end]) {
				ArrayUtils.swap(nums, pivot++, i);
			}
		}
		ArrayUtils.swap(nums, pivot, end);
		return pivot;
	}
	
}
