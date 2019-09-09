package com.juho.algo.prac;

/**
 * You are given a 2D array of characters, and a target string. 
 * Return whether or not the word target word exists in the matrix. Unlike a standard word search, 
 * the word must be either going @leftToRight, or @topToBottom in the matrix.
 * 
 * Example:
 * [['F', 'A', 'C', 'I'],
 *  ['O', 'B', 'Q', 'P'],
 *  ['A', 'N', 'O', 'B'],
 *  ['M', 'A', 'S', 'S']]
 *  
 *  Given this matrix, and the target word FOAM, you should return true, 
 *  as it can be found going up-to-down in the first column.
 *  
 * @author Juho Lee
 * @since Aug 06, 2019
 */
public class problem_0021 {

	public boolean exist(char[][] board, String word) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(find(board, word.toCharArray(), 0, 0, 0))
					return true;
			}
		}
		return false;
	}
	
	public boolean find(char[][] board, char[] word, int i, int x, int y) {
		if(i == word.length)
			return true;
		if(x < 0 || x >= board.length || y < 0 || y > board[x].length || board[x][y] != word[i])
			return false;
		if(find(board, word, i + 1, x + 1, y) ||
		   find(board, word, i + 1, x, y + 1))
			return true;	
		return false;
	}
	
}
