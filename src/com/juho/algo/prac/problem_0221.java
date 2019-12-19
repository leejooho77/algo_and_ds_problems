package com.juho.algo.prac;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 * Input: 27, Output: true
 *
 * Example 2:
 * Input: 0, Output: false
 *
 * Example 3:
 * Input: 9, Output: true
 *
 * Example 4:
 * Input: 45, Output: false
 *
 * Follow up: Could you do it without using any loop / recursion?
 *
 * @author Juho Lee
 * @since Dec 19, 2019
 */
public class problem_0221 {

    public boolean isPowerOfThree_1(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThree_2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}