package com.juho.algo.prac;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * @author Juho Lee
 * @since Oct 26, 2019
 */
public class problem_0133 {

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            result.insert(0, (char)('A' + (n - 1)%26));
            n = (n - 1)/26;
        }
        return result.toString();
    }

}
