package com.juho.algo.prac;

/**
 * Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
 * The returned string must have no leading zeroes, unless the string is "0".
 *
 * Example 1:
 * Input: 2, Output: "110"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
 *
 * Example 2:
 * Input: 3, Output: "111"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 *
 * Example 3:
 * Input: 4, Output: "100"
 * Explantion: (-2) ^ 2 = 4
 *
 * Note: 0 <= N <= 10^9
 *
 * @author Juho Lee
 * @Since Dec 27, 2019
 */
public class problem_0232 {

    public String convertToBaseNeg2_iter(int N) {
        StringBuilder sb = new StringBuilder();
        while(N != 0) {
            sb.insert(0, N & 1);
            N = -(N >> 1);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }

    public String convertToBaseNeg2_recur(int N) {
        if(N == 0 || N == 1) return String.valueOf(N);
        return convertToBaseNeg2_recur(-(N >> 1)) + String.valueOf(N & 1);
    }

}