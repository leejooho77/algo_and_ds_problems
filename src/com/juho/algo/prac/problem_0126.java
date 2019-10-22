package com.juho.algo.prac;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 *
 * You may assume the following rules:
 *  1. A move is guaranteed to be valid and is placed on an empty block.
 *  2. Once a winning condition is reached, no more moves is allowed.
 *  3. A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 * Follow up: Could you do better than O(n^2) per move() operation?
 *
 * @author Juho Lee
 * @since Oct 22, 2019
 */
public class problem_0126 {

    public class TicTacToe {
        int[] rows;
        int[] cols;
        int diags;
        int antiDiags;
        int n;

        public TicTacToe(int n) {
            this.rows = new int[n];
            this.cols = new int[n];
            this.diags = 0;
            this.antiDiags = 0;
            this.n = n;
        }

        public int move(int row, int col, int player) {
            int point = (player == 1) ? player : -1;
            if(row == col)
                this.diags += point;
            if(row + col == n - 1)
                this.antiDiags += point;
            this.rows[col] += point;
            this.cols[row] += point;
            if(Math.abs(this.diags) == n || Math.abs(this.antiDiags) == n ||
                    Math.abs(this.rows[col]) == n || Math.abs(this.cols[row]) == n)
                return player;
            return 0;
        }
    }

}
