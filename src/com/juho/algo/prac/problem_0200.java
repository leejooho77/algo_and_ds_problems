package com.juho.algo.prac;

import com.juho.algo.prac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11, Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3, Output: -1
 *
 * Note: You may assume that you have an infinite number of each kind of coin.
 *
 * @author Juho Lee
 * @since Dec 3, 2019
 */
public class problem_0200 {

    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int amount, int[] dp) {
        // if we have negative amount, we cannot make any change
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        // if we have record in our dp, return it
        if(dp[amount - 1] != 0) return dp[amount - 1];
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            // get the number of changes for @amount with @coin
            int result = coinChange(coins, amount - coin, dp) + 1;
            // get minimum count
            if(result > 0 && min > result) min = result;
        }
        // store minimum into dp
        dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount - 1];
    }

}