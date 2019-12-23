package com.juho.algo.prac;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 *  1. Each of the digits 1-9 must occur exactly once in each row.
 *  2. Each of the digits 1-9 must occur exactly once in each column.
 *  3. Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 * Note:
 *  - The given board contain only digits 1-9 and the character '.'.
 *  - You may assume that the given Sudoku puzzle will have a single unique solution.
 *  - The given board size is always 9x9.
 *
 * @author Juho Lee
 * @since Dec 20, 2019
 */
public class problem_0223 {

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int row, int col) {
        if(col == 9) {
            col = 0;
            if(++row == 9)
                return true;
        }
        if(board[row][col] != '.')
            return solveSudoku(board, row, col + 1);
        for(char c = '1'; c <= '9'; c++) {
            board[row][col] = c;
            if(checkSudoku(board, row, col)) {
                if(solveSudoku(board, row, col + 1))
                    return true;
            }
        }
        board[row][col] = '.';
        return false;
    }

    private boolean checkSudoku(char[][] board, int row, int col) {
        char c = board[row][col];
        for(int i = 0; i < 9; i++) {
            if((i != row && board[i][col] == c) || (i != col && board[row][col] == c))
                return false;
        }
        int br = (row/3) * 3, bc = (col/3) * 3;
        for(int i = br; i < br + 3; i++) {
            for(int j = bc; j < bc + 3; j++) {
                if(i != row && j != col && board[i][j] == c)
                    return false;
            }
        }
        return true;
    }

}