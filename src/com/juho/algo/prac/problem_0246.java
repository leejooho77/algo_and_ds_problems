package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 5, Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @author Juho Lee
 * @since Jan 15, 2020
 */
public class problem_0246 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                row.add((0 < j && j < i)
                        ? pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j)
                        : 1);
            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;

}