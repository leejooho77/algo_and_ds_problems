package com.juho.algo.prac;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 * Input: array = [-1, 2, 1, -4], target = 1, Ouptut: 2
 * Explanation: (-1 + 2 + 1 = 2).
 *
 * @author Juho Lee
 * @since Jan 17, 2020
 */
public class problem_0248 {

    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int difference = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while(start < end) {
                int curr = nums[i];
                curr += (nums[start] + nums[end]);
                int currDiff = Math.abs(target - curr);
                if(currDiff < difference) {
                    difference = currDiff;
                    sum = curr;
                }
                if(curr > target)
                    end--;
                else
                    start++;
            }
        }
        return sum;
    }

}