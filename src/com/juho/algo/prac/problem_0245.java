package com.juho.algo.prac;

import java.util.Arrays;

/**
 * Given a string S and a character C,
 * return an array of integers representing the shortest distance from the character C in the string.
 *
 * Example 1:
 * Input: S = "loveleetcode", C = 'e', Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * Note:
 *  - S string length is in [1, 10000].
 *  - C is a single character, and guaranteed to be in string S.
 *  - All letters in S and C are lowercase.
 *
 * @author Juho Lee
 * @since Jan 14, 2020
 */
public class problem_0245 {

    public int[] shortestToChar(String S, char C) {
        int index = -1;
        int[] result = new int[S.length()];
        Arrays.fill(result, -1);
        for(int i = 0; i < result.length; i++) {
            char sc = S.charAt(i);
            if(sc == C) index = i;
            if(index < 0) continue;
            else result[i] = i - index;
        }
        index = -1;
        for(int i = result.length - 1; i >= 0; i--) {
            char sc = S.charAt(i);
            if(sc == C) index = i;
            if(index < 0) continue;
            else result[i] = result[i] < 0 ? index - i : Math.min(result[i], index - i);
        }
        return result;
    }

}