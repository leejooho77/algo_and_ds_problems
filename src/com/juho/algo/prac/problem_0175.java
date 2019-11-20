package com.juho.algo.prac;

/**
 * Given an array consisting of n integers,
 * find the contiguous subarray of given length k that has the maximum average value.
 * And you need to output the maximum average value.
 *
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4, Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 * Note:
 *  - 1 <= k <= n <= 30,000.
 *  - Elements of the given array will be in the range [-10,000, 10,000].
 *
 * @author Juho Lee
 * @since Nov 19, 2019
 */
public class problem_0175 {

    public double findMaxAverage(int[] nums, int k) {
        Double max = null;
        int l = 0, r = 0;
        double sum = 0;
        for(; r <= nums.length; r++) {
            if(r - l == k) {
                max = (max == null) ? sum : Math.max(max, sum);
                sum -= nums[l++];
                if(r == nums.length)
                    break;
            }
            sum += nums[r];
        }
        return max/k;
    }

}