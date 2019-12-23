package com.juho.algo.prac;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 * Input: 5, Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Example 2:
 * Input: 3, Output: False
 *
 * @author Juho Lee
 * @since Dec 23, 2019
 */
public class problem_0224 {

    public boolean judgeSquareSum_1(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while(a <= b) {
            int curr = a * a + b * b;
            if(curr == c)
                return true;
            else if(curr > c)
                b--;
            else
                a++;
        }
        return false;
    }

    public boolean judgeSquareSum_2(int c) {
        Set<Integer> set = new HashSet<>();
        double b = Math.sqrt(c);
        for(int i = 0; i <= b; i++) {
            set.add(i * i);
            if(set.contains(c - (i * i)))
                return true;
        }
        return false;
    }

}