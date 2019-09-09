package com.juho.algo.prac;

/**
 * Given a sorted array, A, with possibly duplicated elements, 
 * find the indices of the first and last occurrences of a target element, x. 
 * Return -1 if the target is not found.
 * 
 * Example:
 * Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9, Output: [6,8]
 * Input: A = [100, 150, 150, 153], target = 150, Output: [1,2]
 * Input: A = [1,2,3,4,5,6,10], target = 9, Output: [-1, -1]
 * 
 * @author Juho Lee
 * @since July 22, 2019
 */
public class problem_0005 {

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1, -1};
		int mid = search(nums, 0, nums.length - 1, target);
		if(mid != -1) {
			result[0] = searchEnd(nums, 0, mid - 1, target, true);
			result[1] = searchEnd(nums, mid + 1, nums.length - 1, target, false);
		}
		return result;
	}
	
	public int search(int[] nums, int start, int end, int target) {
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(nums[mid] == target) return mid;
			else if(nums[mid] < target)
				start = mid + 1;
			else 
				end = mid - 1;
		}
		return -1;
	}
	
	public int searchEnd(int[] nums, int start, int end, int target, boolean left) {
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(nums[mid] == target) {
				if(left) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if(nums[mid] < target)
				start = mid + 1;
			else 
				end = mid - 1;
		}
		return (left) ? start : end;
	}
	
}
