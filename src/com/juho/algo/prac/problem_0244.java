package com.juho.algo.prac;

import com.juho.algo.prac.util.ArrayUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * You are only allowed to perform 2 operations, multiply a number by 2, or subtract a number by 1.
 * Given a number x and a number y, find the minimum number of operations needed to go from x to y.
 *
 * Example:
 * Input: 6, 20, Output: 3
 * Explanation: 1. (6 - 1) = 5
 *              2. (5 * 2) = 10
 *              3. (10 * 2) = 20
 *
 * @author Juho Lee
 * @since Jan 13, 2020
 */
public class problem_0244 {

    public int minOperations(int n, int target) {
        int count = 0;
        while(target != n) {
            // if target is odd number or less than n, increment by 1
            // else divide by 2
            if((target % 2 != 0) || (target < n)){
                target++;
            } else {
                target /= 2;
            }
            count++;
        }
        return count;
    }

}