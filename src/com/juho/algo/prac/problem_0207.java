package com.juho.algo.prac;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number,
 * also in sorted non-decreasing order.
 *
 * Example 1:
 * Input: [-4,-1,0,3,10], Output: [0,1,9,16,100]
 *
 * Example 2:
 * Input: [-7,-3,2,3,11], Output: [4,9,9,49,121]
 *
 * Note:
 *  - 1 <= A.length <= 10000
 *  - -10000 <= A[i] <= 10000
 *  - A is sorted in non-decreasing order.
 *
 * @author Juho Lee
 * @since Dec 9, 2019
 */
public class problem_0207 {

    public int[] sortedSquares(int[] A) {
        if(A.length == 0) return A;
        int neg = 0;
        int[] ans = new int[A.length];
        while(neg < A.length) {
            if(A[neg] >= 0) {
                break;
            }
            neg++;
        }
        neg -= 1;
        int i = 0;
        int pos = neg + 1;
        while(neg >= 0 && pos < A.length) {
            int negVal = A[neg] * A[neg];
            int posVal = A[pos] * A[pos];
            if(negVal < posVal) {
                ans[i] = negVal;
                neg--;
            } else {
                ans[i] = posVal;
                pos++;
            }
            i++;
        }

        while(neg >= 0) {
            int negVal = A[neg] * A[neg];
            ans[i] = negVal;
            neg--;
            i++;
        }

        while(pos < A.length) {
            int posVal = A[pos] * A[pos];
            ans[i] = posVal;
            pos++;
            i++;
        }
        return ans;
    }

}