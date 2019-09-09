package com.juho.algo.prac;

import java.util.Arrays;

/**
 * You 2 integers n and m representing an n by m grid, 
 * determine the number of ways you can get from the top-left to the bottom-right of the matrix y going only right or down.
 * 
 * Example:
 * n = 2, m = 2, This should return 2, 
 * since the only possible routes are:
 *  1. Right, down
 *  2. Down, right.
 * 
 * @author leejooho77
 * @since Aug 08, 2019
 */
public class problem_0023 {

	public int numWays(int n, int m) {
		int[][] matrix = new int[n][m];
		Arrays.fill(matrix[0], 1);
		for(int i = 1; i < n; i++) {
			matrix[i][0] = 1;
			for(int j = 1; j < m; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}
		return matrix[n - 1][m - 1];
	}
	
}
