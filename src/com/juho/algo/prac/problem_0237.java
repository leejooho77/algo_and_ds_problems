package com.juho.algo.prac;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 * Input: numerator = 1, denominator = 2, Output: "0.5"
 *
 * Example 2:
 * Input: numerator = 2, denominator = 1, Output: "2"
 *
 * Example 3:
 * Input: numerator = 2, denominator = 3, Output: "0.(6)"
 *
 * @author Juho Lee
 * @since Jan 11, 2020
 */
public class problem_0237 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        if(numerator < 0 && denominator > 0
                || numerator > 0 && denominator < 0)
            result.append("-");
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        // Key: remainder, Value: index in String
        Map<Long, Integer> map = new HashMap<>();
        result.append(numeratorL/denominatorL);
        long remainder = (numeratorL % denominatorL) * 10;
        if(remainder != 0)
            result.append(".");
        while(remainder != 0) {
            // if there is a remainder in the map,
            // we know that the repetition starts from here
            // and ends where we are.
            // so insert '(' at the start of the repetition
            // and append ')' at the end of the repetition
            if(map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");
                result.append(")");
                return result.toString();
            } else {
                map.put(remainder, result.length());
                result.append(remainder/denominatorL);
                remainder = (remainder % denominatorL) * 10;
            }
        }
        return result.toString();
    }

}