package com.juho.algo.prac;

/**
 * Version numbers are strings that are used to identify unique states of software products.
 * A version number is in the format a.b.c.d. and so on where a, b, etc. are numeric strings separated by dots.
 * These generally represent a hierarchy from major to minor changes.
 * Given two version numbers version1 and version2, conclude which is the latest version number. Your code should do the following:
 *
 * If version1 > version2 return 1.
 * If version1 < version2 return -1.
 * Otherwise return 0.
 *
 * Note that the numeric strings such as a, b, c, d, etc. may have leading zeroes,
 * and that the version strings do not start or end with dots. Unspecified level revision numbers default to 0.
 *
 * Example:
 * Input1:
 * version1 = "1.0.33"
 * version2 = "1.0.27"
 * Output1: 1
 * version1 > version2
 *
 * Input2:
 * version1 = "0.1"
 * version2 = "1.1"
 * Output2: -1
 * version1 < version2
 *
 * Input3:
 * version1 = "1.01"
 * version2 = "1.001"
 * Output3: 0
 * ignore leading zeroes, 01 and 001 represent the same number.
 *
 * Input4:
 * version1 = "1.0"
 * version2 = "1.0.0"
 * Output4: 0
 * version1 does not have a 3rd level revision number, which defaults to "0"
 *
 * @author Juho Lee
 * @since Oct 25, 2019
 */
public class problem_0131 {

    public int compareVersion(String V1, String V2) {
        String[] A = V1.split("\\.");
        String[] B = V2.split("\\.");
        int a = 0, b = 0;
        while(a < A.length || b < B.length) {
            int v1 = (a < A.length) ? Integer.valueOf(A[a++]) : 0;
            int v2 = (b < B.length) ? Integer.valueOf(B[b++]) : 0;
            if(v1 > v2) return 1;
            else if(v1 < v2) return -1;
            else continue;
        }
        return 0;
    }

}
