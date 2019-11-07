package com.juho.algo.prac;

/**
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
 * The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * A chess knight has 8 possible moves and each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 *
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random
 * (even if the piece would go off the chessboard) and moves there.
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard.
 * Return the probability that the knight remains on the board after it has stopped moving.
 *
 * Example:
 * Input: 3, 2, 0, 0, Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 *              From each of those positions, there are also two moves that will keep the knight on the board.
 *              The total probability the knight stays on the board is 0.0625.
 *
 * Note:
 *  - N will be between 1 and 25.
 *  - K will be between 0 and 100.
 *  - The knight always initially starts on the board.
 *
 * @author Juho Lee
 * @since Nov 5, 2019
 */
public class problem_0153 {

    /**
     * Parameter Clarification:
     * @param N number of rows and cols in chessboard
     * @param K number of moves that knight has
     * @param r current row
     * @param c current col
     * @return double
     */
    public double knightProbability(int N, int K, int r, int c) {
        int[][] possibleMoves = new int[][] {{2,1},{1,2},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
        double[][][] probability = new double[K + 1][N][N];
        probability[0][r][c] = 1;
        for(int k = 1; k <= K; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int[] possibleMove : possibleMoves) {
                        int R = i + possibleMove[0];
                        int C = j + possibleMove[1];
                        if(R >= 0 && R < N && C >= 0 && C < N) {
                            probability[k][i][j] += probability[k - 1][R][C]/8.0;
                        }
                    }
                }
            }
        }
        double result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                result += probability[K][i][j];
            }
        }
        return result;
    }

}