package com.juho.algo.prac;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3, Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4, Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author Juho Lee
 * @since Oct 20, 2019
 */
public class problem_0121 {

    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() < numRows)
            return s;
        int zigzag = 2 * (numRows - 1);
        int start = 0, space = 0, i = 0;
        char[] result = new char[s.length()];
        while(zigzag >= 0) {
            int j = start;
            result[i++] = s.charAt(j);
            while(j < s.length()) {
                if(zigzag > 0) {
                    j += zigzag;
                    if(j < s.length())
                        result[i++] = s.charAt(j);
                }
                if(space > 0) {
                    j += space;
                    if(j < s.length())
                        result[i++] = s.charAt(j);
                }
            }
            zigzag -= 2;
            space += 2;
            start++;
        }
        return new String(result);
    }

}
