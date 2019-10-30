package com.juho.algo.prac;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 *
 * Example:
 * Input: 28, Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 *
 * Note: The input number n will not exceed 100,000,000. (1e8)
 *
 * @author Juho Lee
 * @since Oct 29, 2019
 */
public class problem_0139 {

    public boolean checkPerfectNumber(int num) {
        int p = 1, div = 2;
        for(; div * div < num; div++) {
            if(div * (num/div) == num)
                p += (div + num/div);
        }
        return num != 1 && num == p;
    }
}
