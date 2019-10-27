package com.juho.algo.prac;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * @author Juho Lee
 * @since Oct 26, 2019
 */
public class problem_0132 {

    public int titleToNumber(String s) {
        int result = 0, pow = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            result += pow * (s.charAt(i) - 'A' + 1);
            pow *= 26;
        }
        return result;
    }

}
