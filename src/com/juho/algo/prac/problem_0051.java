package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array, nums, of n integers, 
 * find all unique triplets (three numbers, a, b, & c) in nums such that a + b + c = 0. 
 * Note that there may not be any triplets that sum to zero in nums, and that the triplets must not be duplicates.
 * 
 * Example:
 * Input: nums = [0, -1, 2, -3, 1], Output: [0, -1, 1], [2, -3, 1]
 * 
 * @author Juho Lee
 * @since Sep 06, 2019
 */
public class problem_0051 {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
        	// skip same start value
            if(i == 0 || i > 0 && nums[i - 1] != nums[i]) {
                int twoSum = 0 - nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while(start < end) {
                    if(twoSum > nums[start] + nums[end]) start++;
                    else if(twoSum < nums[start] + nums[end]) end--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        // if we found duplicates in the list, skip all of them
                        while(start < end && nums[start] == nums[start + 1]) start++;
                        while(start < end && nums[end - 1] == nums[end]) end--;
                        start++;
                        end--;
                    }
                }
            }
        }
        return result;
	}
	
}
