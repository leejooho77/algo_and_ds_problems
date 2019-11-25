package com.juho.algo.prac;

/**
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 * Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * @author Juho Lee
 * @since Nov 25, 2019
 */
public class problem_0189 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rf = obstacleGrid.length - 1, cf = obstacleGrid[rf].length - 1;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rf][cf] == 1)
            return 0;
        boolean rowBlock = false, colBlock = false;
        for(int r = 0; r < obstacleGrid.length; r++) {
            for(int c = 0; c < obstacleGrid[r].length; c++) {
                if(obstacleGrid[r][c] == 1) {
                    obstacleGrid[r][c] = -1;
                    if(r == 0) rowBlock = true;
                    if(c == 0) colBlock = true;
                }
                else if(r == 0 && !rowBlock)
                    obstacleGrid[r][c] = 1;
                else if(c == 0 && !colBlock)
                    obstacleGrid[r][c] = 1;
                else if(r > 0 && c > 0)
                    obstacleGrid[r][c] = ((obstacleGrid[r - 1][c] > 0) ? obstacleGrid[r - 1][c] : 0) +
                            ((obstacleGrid[r][c - 1] > 0) ? obstacleGrid[r][c - 1] : 0);
            }
        }
        return obstacleGrid[rf][cf];
    }

}