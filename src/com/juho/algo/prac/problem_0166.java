package com.juho.algo.prac;

/**
 * Given a positive integer n,
 * break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * Example 1:
 * Input: 2, Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 * Input: 10, Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * @author Juho Lee
 * @since Nov 15, 2019
 */
public class problem_0166 {

    public int integerBreak(int n) {
        if(n == 1)
            return n;
        if(n < 4)
            return n - 1;
        else {
            int result = 1;
            while(n > 4) {
                result *= 3;
                n -= 3;
            }
            return result * n;
        }
    }

}