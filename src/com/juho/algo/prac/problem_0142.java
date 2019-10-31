package com.juho.algo.prac;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 *
 * Example 1:
 * Input: [[4,3,8,4],
 *         [9,5,1,9],
 *         [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 *
 * while this one is not:
 * 384
 * 519
 * 762
 *
 * In total, there is only one magic square inside the given grid.
 *
 * Note:
 *  1. 1 <= grid.length <= 10
 *  2. 1 <= grid[0].length <= 10
 *  3. 0 <= grid[i][j] <= 15
 *
 * @author Juho Lee
 * @since Oct 30, 2019
 */
public class problem_0142 {

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        if(grid.length < 3 || grid[0].length < 3)
            return count;
        for(int i = 0; i + 2 < grid.length; i++) {
            for(int j = 0; j + 2 < grid[i].length; j++) {
                int[] check = new int[9];
                int horizon = scanHorizon(grid, check, i, j);
                int vertical = scanVertical(grid, i, j);
                int diagonal = scanDiagonal(grid, i, j);
                if(horizon > 0 && horizon == vertical && vertical == diagonal)
                    count++;
            }
        }
        return count;
    }

    private int scanHorizon(int[][] grid, int[] check, int i, int j) {
        int result = 0;
        for(int k = i; k < i + 3; k++) {
            int sum = 0;
            for(int l = j; l < j + 3; l++) {
                if(grid[k][l] < 1 || grid[k][l] > 9 || check[grid[k][l] - 1] > 0)
                    return -1;
                check[grid[k][l] - 1]++;
                sum += grid[k][l];
            }
            if(result == 0)
                result = sum;
            else if(result != sum)
                return -1;
        }
        return result;
    }

    private int scanVertical(int[][] grid, int i, int j) {
        int result = 0;
        for(int k = j; k < j + 3; k++) {
            int sum = 0;
            for(int l = i; l < i + 3; l++) {
                sum += grid[l][k];
            }
            if(result == 0)
                result = sum;
            else if(result != sum)
                return -1;
        }
        return result;
    }

    private int scanDiagonal(int[][] grid, int i, int j) {
        int result = 0;
        for(int k = i, l = j; k < i + 3 && l < j + 3; k++, l++) {
            result += grid[k][l];
        }
        int sum = 0;
        for(int k = i + 2, l = j; k >= i && l < j + 3; k--, l++) {
            sum += grid[k][l];
        }
        result = (result == sum) ? result : -1;
        return result;
    }

}
