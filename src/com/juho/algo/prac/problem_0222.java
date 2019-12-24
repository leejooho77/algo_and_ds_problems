package com.juho.algo.prac;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *  1. Each row must contain the digits 1-9 without repetition.
 *  2. Each column must contain the digits 1-9 without repetition.
 *  3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ], Output: true
 *
 * Example 2:
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ], Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *              modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * @author Juho Lee
 * @since Dec 20, 2019
 */
public class problem_0222 {

    public boolean isValidSudoku(char[][] board) {
        Set<String> cache = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && (!cache.add(i + "r" + board[i][j])
                        || !cache.add(j + "c" + board[i][j])
                        || !cache.add(i/3 + "b" + j/3 + board[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }

}