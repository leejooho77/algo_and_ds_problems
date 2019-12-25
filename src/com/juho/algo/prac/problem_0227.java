package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 *
 * @author Juho Lee
 * @since Dec 25, 2019
 */
public class problem_0227 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(result, new ArrayList<>(), n);
        return result;
    }

    private void solveNQueens(List<List<String>> result, List<String> board, int n) {
        if(board.size() == n)
            result.add(new ArrayList<>(board));
        else {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            for(int i = 0; i < n; i++) {
                c[i] = 'Q';
                board.add(new String(c));
                if(checkQueens(board, i))
                    solveNQueens(result, board, n);
                c[i] = '.';
                board.remove(board.size() - 1);
            }
        }
    }

    private boolean checkQueens(List<String> board, int m) {
        for(int i = 0; i < board.size() - 1; i++) {
            int diff = board.size() - i - 1;
            String prev = board.get(i);
            if(prev.charAt(m) == 'Q' ||
                    (m - diff >= 0 && prev.charAt(m - diff) == 'Q') ||
                    (m + diff < prev.length() && prev.charAt(m + diff) == 'Q'))
                return false;
        }
        return true;
    }

}