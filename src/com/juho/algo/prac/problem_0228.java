package com.juho.algo.prac;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * @author Juho Lee
 * @since Dec 25, 2019
 */
public class problem_0228 {

    public int totalNQueens(int n) {
        int[] board = new int[n];
        return totalNQueens(board, n, 0);
    }

    private int totalNQueens(int[] board, int n, int m) {
        if(m == n) {
            return 1;
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            board[m] = i;
            if(checkQueens(board, m))
                count += totalNQueens(board, n, m + 1);
        }
        return count;
    }

    private boolean checkQueens(int[] board, int m) {
        int curr = board[m];
        for(int i = 0; i < m; i++) {
            if(curr == board[i] || curr == board[i] + (m - i) || curr == board[i] - (m - i))
                return false;
        }
        return true;
    }

}