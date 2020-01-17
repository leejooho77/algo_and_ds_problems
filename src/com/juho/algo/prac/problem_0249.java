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
 * @since Jan 17, 2020
 */
public class problem_0249 {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int ai = a.length() - 1, bi = b.length() - 1, carry = 0;
        while(ai >= 0 || bi >= 0) {
            int ab = (ai >= 0) ? a.charAt(ai) - '0' : 0;
            int bb = (bi >= 0) ? b.charAt(bi) - '0' : 0;
            int sum = ab + bb + carry;
            result.insert(0, sum % 2);
            carry = sum / 2;
            ai--;
            bi--;
        }
        if(carry > 0) result.insert(0, carry);
        return (result.length() > 0) ? result.toString() : "0";
    }

}