package com.juho.algo.prac;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 *
 * Recall that A is a mountain array if and only if:
 *  1. A.length >= 3
 *  2. There exists some i with 0 < i < A.length - 1 such that:
 *      - A[0] < A[1] < ... A[i-1] < A[i]
 *      - A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * Note:
 *  - 0 <= A.length <= 10000
 *  - 0 <= A[i] <= 10000
 *
 * @author Juho Lee
 * @since Oct 28, 2019
 */
public class problem_0140 {

    public boolean validMountainArray(int[] A) {
        int inc = 0, dec = A.length - 1;
        while(inc < A.length - 1 && A[inc] < A[inc + 1]) inc++;
        while(dec > 0 && A[dec] < A[dec - 1]) dec--;
        return dec > 0 && inc < A.length - 1 && inc == dec;
    }

}
