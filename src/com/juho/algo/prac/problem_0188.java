package com.juho.algo.prac;

/**
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 * Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 *
 * @author Juho Lee
 * @since Nov 25, 2019
 */
public class problem_0188 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int r = 0; r < dp.length; r++) {
            for(int c = 0; c < dp[r].length; c++) {
                if(r == 0 || c == 0)
                    dp[r][c] = 1;
                else
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}