package com.juho.algo.prac;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, 
 * except for one element which appears exactly once. Find this single element that appears only once.
 * 
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8], Output: 2
 * 
 * Example 2:
 * Input: [3,3,7,7,10,11,11], Output: 10
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * @author Juho Lee
 * @since Oct 3, 2019
 */
public class problem_0095 {

	public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length - 1);
    }
    
    private int singleNonDuplicate(int[] nums, int start, int end) {
        if(start >= end) return nums[start];
        int mid = start + (end - start)/2;
        // if we found duplicate at previous index
        if(nums[mid] == nums[mid - 1]) {
        	// get the size from start to mid
            if((mid - start + 1) % 2 == 0)
            	// if we have even size, we have single element between mid + 1 to end
                return singleNonDuplicate(nums, mid + 1, end);
            else
            	// else we have single element between start to mid - 2 (remove duplicate)
                return singleNonDuplicate(nums, start, mid - 2);
        }
        // if we found duplicate at mid + 1
        else if(nums[mid] == nums[mid + 1]) {
        	// get the size from mid to end
            if((end - mid + 1) % 2 == 0)
            	// if we have even size, we have single element between start to mid - 1
                return singleNonDuplicate(nums, start, mid - 1);
            else
            	// else we have single element between mid + 2 (remove duplicate) to end
                return singleNonDuplicate(nums, mid + 2, end);
        }
        else
            return nums[mid];
    }
	
}
