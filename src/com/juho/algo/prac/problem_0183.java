package com.juho.algo.prac;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 * Input: 16, Output: true
 *
 * Example 2:
 * Input: 5, Output: false
 *
 * Follow up: Could you solve it without loops/recursion?
 *
 * @author Juho Lee
 * @since Nov 23, 2019
 */
public class problem_0183 {

    public boolean isPowerOfFourWithLogBase2(int num) {
        double result = Math.log(num)/Math.log(2);
        return (result % 2 == 0);
    }

    public boolean isPowerOfFourWithBit(int num) {
        return (num > 0 && ((num & (num - 1)) == 0) && (num & 0x55555555) == num);
    }

}