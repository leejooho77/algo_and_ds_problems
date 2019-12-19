package com.juho.algo.prac;

/**
 * ---- V1 ----
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 * Input: 4, Output: 2
 *
 * Example 2:
 * Input: 8, Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * ---- V2 ----
 * Given a positive integer, find the square root of the integer without using
 * any built in square root or power functions (math.sqrt or the ** operator).
 * Give accuracy up to 3 decimal points.
 *
 * Example 1:
 * Input: 5, Output: 2.236
 *
 * @author Juho Lee
 * @since Dec 18, 2019
 */
public class problem_0218 {

    private static final int DECIMAL = 1000;

    public int mySqrt_v1(int x) {
        if(x == 0)
            return x;
        int start = 1, end = x;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(mid > x/mid)
                end = mid;
            else
                start = mid;
        }
        return start;
    }

    public double mySqrt_v2(int x) {
        double start = 0, end = x, newX = x;
        while(start < end) {
            double mid = start + (end - start) / 2;
            if((int)(mid * DECIMAL) == (int)(x/mid * DECIMAL))
                return mid;
            else if((int)(mid * DECIMAL) > (int)(x/mid * DECIMAL))
                end = mid;
            else start = mid;
        }
        return start;
    }

}