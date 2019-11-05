package com.juho.algo.prac;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 * Input: 3, Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 * Input: 5, Output: 1
 * Explanation: 5! = 120, one trailing zero.
 *
 * Note: Your solution should be in logarithmic time complexity.
 *
 * @author Juho Lee
 * @since Nov 5, 2019
 */
public class problem_0152 {

    /**
     * Approach: count the number of 5.
     * Example:
     * Input: 25 => 1 x 2 x ... x (5) x ... (2 x 5) x ..... x (3 x 5) x .... x (4 x 5) x .... (5 x 5), Output: 6
     *
     * @param n
     * @return int
     */
    public int trailingZeroes(int n) {
        int zeroes = n/5;
        n /= 5;
        while(n > 0) {
            zeroes += n/5;
            n /= 5;
        }
        return zeroes;
    }

}