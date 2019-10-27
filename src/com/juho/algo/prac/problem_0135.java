package com.juho.algo.prac;

/**
 * Return the longest run of 1s for a given integer n's binary representation.
 *
 * Example:
 * Input: 242, Output: 4
 * 242 in binary is 0b11110010, so the longest run of 1 is 4.
 *
 * @author Juho Lee
 * @since Oct 27, 2019
 */
public class problem_0135 {

    public int longestOnes(int n) {
        int curr = 0, max =0;
        while(n > 0) {
            if((n & 1) == 1)
                curr++;
            else
                curr = 0;
            n >>>= 1;
            max = Math.max(max, curr);
        }
        return max;
    }

}
