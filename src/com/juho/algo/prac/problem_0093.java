package com.juho.algo.prac;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *  - F(0) = 0,   F(1) = 1
 *  - F(N) = F(N - 1) + F(N - 2), for N > 1.
 * 
 * Given N, calculate F(N).
 * 
 * @author Juho Lee
 * @since Oct 2, 2019
 */
public class problem_0093 {

	public int fibIterative(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        if(N > 0)
            dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
	
	public int fibRecursive(int N) {
		if(N < 2) return N;
        return fibRecursive(N - 1) + fibRecursive(N - 2);
    }
	
}
