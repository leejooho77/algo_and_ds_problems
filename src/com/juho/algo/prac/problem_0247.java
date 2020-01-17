package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 3, Output: [1,3,3,1]
 *
 * Follow up: Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author Juho Lee
 * @since Jan 16, 2020
 */
public class problem_0247 {

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < rowIndex; i++) {
            result.add(0, 1);
            for(int j = 1; j < result.size() - 1; j++) {
                result.set(j, result.get(j) + result.get(j + 1));
            }
        }
        return result;
    }

}