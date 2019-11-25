package com.juho.algo.prac;

/**
 * Given a string, return the first recurring letter that appears. If there are no recurring letters, return None.
 *
 * Example 1:
 * Input: qwertty, Output: t
 *
 * Example 2:
 * Input: qwerty, Output:
 *
 * @author Juho Lee
 * @since Nov 24, 2019
 */
public class problem_0185 {

    public char firstRecurringCharacter(String s) {
        int[] set = new int[26];
        for(char c : s.toCharArray()) {
            if(set[c - 'a'] > 0)
                return c;
            set[c - 'a']++;
        }
        return ' ';
    }

}