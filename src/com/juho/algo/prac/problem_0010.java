package com.juho.algo.prac;

/**
 * You are given an array of integers in an arbitrary order. 
 * Return whether or not it is possible to make the array non-decreasing by modifying at most 1 element to any value.
 * 
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * 
 * Example:
 * [13, 4, 7] should return true, 
 * 	          since we can modify 13 to any value 4 or less, to make it non-decreasing.
 * [13, 4, 1] however, should return false, 
 * 			  since there is no way to modify just one element to make the array non-decreasing.
 * 
 * @author Juho Lee
 * @since July 27, 2019
 *
 */
public class problem_0010 {
	
	public boolean check(int[] nums) {
		/*************************************/
        int count = 0;
        /*************************************/
        // Approach: check the count of decreasing sub-array
        // if count is larger than 1, check if we can fix
        // if we can fix return true
        // else return false
        // Ex) [4,2,1] => 2 ([4,2], [2,1])
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                // if we in the middle
                if(i > 0 && i + 1 < nums.length - 1) {
                    if(nums[i + 2] < nums[i] && nums[i - 1] > nums[i + 1]) 
                        return false;
                }
                count++;
            }
            // if there are more than one decreasing sub-array
            // return false
            if(count > 1) return false;
        }
        return true;
	}

}
