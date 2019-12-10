package com.juho.algo.prac;

/**
 * Given a 2d n x m matrix where each cell has a certain amount of change on the floor,
 * your goal is to start from the top left corner mat[0][0] and end in the bottom right corner mat[n - 1][m - 1]
 * with the most amount of change. You can only move either left or down.
 *
 * @author Juho Lee
 * @since Dec 10, 2019
 */
public class problem_0208 {

    public int maxChanges(int[][] grid) {
        if(grid.length == 0 || grid == null) return 0;
        int r = grid.length - 1, c = grid[r].length - 1;
        for(int i = 1; i <= r; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for(int i = 1; i <= c; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[r][c];
    }

    public static void main(String[] args) {
        System.out.println(new problem_0208().maxChanges(new int[][] {}));
    }

}