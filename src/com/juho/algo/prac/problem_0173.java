package com.juho.algo.prac;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *  1. sumRange(0, 2) -> 1
 *  2. sumRange(2, 5) -> -1
 *  3. sumRange(0, 5) -> -3
 *
 * Note:
 *  - You may assume that the array does not change.
 *  - There are many calls to sumRange function.
 *
 * @author Juho Lee
 * @since Nov 19, 2019
 */
public class problem_0173 {

    public class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            for (int i = 1; i < nums.length; i++) {
                this.nums[i] += this.nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return (i - 1) >= 0 ? this.nums[j] - this.nums[i - 1] : this.nums[j];
        }
    }

}