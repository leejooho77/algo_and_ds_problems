package com.juho.algo.prac;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3, Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2, Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * @author Juho Lee
 * @since Dec 6, 2019
 */
public class problem_0206 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;
        int repeat = getGCD(k, nums.length);
        int i = 0;
        while(i < repeat) {
            int val = nums[i];
            int index = (k + i) % nums.length;
            while(index != i) {
                int tmp = nums[index];
                nums[index] = val;
                index = (index + k) % nums.length;
                val = tmp;
            }
            nums[index] = val;
            i++;
        }
    }

    private int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a % b);
    }

}