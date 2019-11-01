package com.juho.algo.prac;

/**
 * A boomerang is a set of 3 points that are all distinct and not in a straight line.
 * Given a list of three points in the plane, return whether these points are a boomerang.
 *
 * Example 1:
 * Input: [[1,1],[2,3],[3,2]], Output: true
 *
 * Example 2:
 * Input: [[1,1],[2,2],[3,3]], Output: false
 *
 * Note:
 *  - points.length == 3
 *  - points[i].length == 2
 *  - 0 <= points[i][j] <= 100
 *
 * @author Juho Lee
 * @since Nov 1, 2019
 */
public class problem_0148 {

    public boolean isBoomerang(int[][] points) {
        int slope1 = (points[1][1] - points[0][1])*(points[2][0] - points[0][0]);
        int slope2 = (points[2][1] - points[0][1])*(points[1][0] - points[0][0]);
        return slope1 != slope2;
    }

}