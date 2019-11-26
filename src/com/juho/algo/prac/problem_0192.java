package com.juho.algo.prac;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3, Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3, Output: -2
 *
 * Note:
 *  - Both dividend and divisor will be 32-bit signed integers.
 *  - The divisor will never be 0.
 *  - Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 *    For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 *
 * @author Juho Lee
 * @since Nov 26, 2019
 */
public class problem_0192 {

    public int divide(int dividend, int divisor) {
        if(dividend == (1 << 31) && divisor == -1)
            return (1 << 31) - 1;
        int a = Math.abs(dividend), b = Math.abs(divisor), result = 0, x = 0;
        while(a - b >= 0) {
            for(x = 0; a - (b << x << 1) >= 0; x++);
            result += (1 << x);
            a -= (b << x);
        }
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }

}