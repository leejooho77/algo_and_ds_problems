package com.juho.algo.prac;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 * Input: "Hello, my name is John", Output: 5
 *
 * @author Juho Lee
 * @since Nov 1, 2019
 */
public class problem_0147 {

    public int countSegments(String s) {
        int count = 0;
        String[] segments = s.split(" ");
        for(String seg : segments) {
            if(seg.length() > 0) count++;
        }
        return count;
    }

}