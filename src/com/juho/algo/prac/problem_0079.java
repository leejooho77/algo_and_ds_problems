package com.juho.algo.prac;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * Input: 123, Output: 321
 * 
 * Example 2:
 * Input: -123, Output: -321
 * 
 * Example 3:
 * Input: 120, Output: 21
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. 
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * @author Juho Lee
 * @since Sep 23, 2019
 */
public class problem_0079 {

	public int reverse(int x) {
		int sign = (x < 0) ? -1 : 1;
		int result = 0;
		x = Math.abs(x);
		while(x > 0) {
			int prev = result;
			result = result * 10 + (x % 10);
			// check overflow
			if(result / 10 != prev) return 0;
			x /= 10;
		}
		return sign * result;
	}
	
}
