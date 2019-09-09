package com.juho.algo.prac;

/**
 * You are given an array. Each element represents the price of a stock on that particular day. 
 * Calculate and return the maximum profit you can make from buying and selling that stock only once.
 * 
 * For example: [9, 11, 8, 5, 7, 10]
 * Here, the optimal trade is to buy when the price is 5, and sell when it is 10, 
 * so the return value should be 5 (profit = 10 - 5 = 5).
 * 
 * @author leejooho77
 * @since Aug 20, 2019
 */
public class problem_0034 {
	
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, result = 0;
		for(int i : prices) {
			min = Math.min(min, i);
			result = Math.max(result, i - min);
		}
		return result;
	}

}
