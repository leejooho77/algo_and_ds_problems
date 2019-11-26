package com.juho.algo.prac;

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1", Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011", Output: "10101"
 *
 * @author Juho Lee
 * @since Nov 26, 2019
 */
public class problem_0191 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int A = a.length() - 1, B = b.length() - 1, carry = 0;
        while(A >= 0 || B >= 0) {
            int ai = (A >= 0) ? a.charAt(A--) - '0' : 0;
            int bi = (B >= 0) ? b.charAt(B--) - '0' : 0;
            int sum = ai + bi + carry;
            carry = sum/2;
            sb.insert(0, sum % 2);
        }
        if(carry > 0)
            sb.insert(0, carry);
        return sb.toString();
    }

}