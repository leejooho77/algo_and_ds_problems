package com.juho.algo.prac;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * Input: 11110
 *        11010
 *        11000
 *        00000
 * Output: 1
 * 
 * @author Juho Lee
 * @since Sep 08, 2019
 */
public class problem_0053 {
	
	public int numIslands(char[][] grid) {
		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1') {
					flip(grid, i, j);
                    count++;
				}
			}
		}
		return count;
	}
	
	public void flip(char[][] grid, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
			return;
        grid[i][j] = '0';
		flip(grid, i + 1, j);
		flip(grid, i, j + 1);
        flip(grid, i - 1, j);
        flip(grid, i, j - 1);
	}

}
