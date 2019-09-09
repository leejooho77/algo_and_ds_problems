package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a 2D array of integers. Print out the clockwise spiral traversal of the matrix.
 * 
 * Example:
 * grid = [[1,  2,  3,  4,  5],
 * 		   [6,  7,  8,  9,  10],
 * 		   [11, 12, 13, 14, 15],
 *         [16, 17, 18, 19, 20]
 *        ]
 * 
 * The clockwise spiral traversal of this array is:
 * 1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12
 * 
 * @author Juho Lee
 * @since Aug 17, 2019
 */
public class problem_0031 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;
		int minRow = 0, maxRow = matrix.length - 1; 
		int minCol = 0, maxCol = matrix[minRow].length - 1;
		while(minCol <= maxCol && minRow <= maxRow) {
			for(int i = minCol; i <= maxCol; i++) result.add(matrix[minRow][i]);
			for(int i = minRow + 1; i <= maxRow; i++) result.add(matrix[i][maxCol]);
            if(minRow < maxRow && minCol < maxCol) {
                for(int i = maxCol - 1; i >= minCol + 1; i--) result.add(matrix[maxRow][i]);
                for(int i = maxRow; i >= minRow + 1; i--) result.add(matrix[i][minCol]);
            }
			minRow++;
			maxRow--;
			minCol++;
			maxCol--;
		}
		return result;
	}
	
}
