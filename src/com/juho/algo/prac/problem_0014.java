package com.juho.algo.prac;

/**
 * You are given a positive integer N which represents the number of steps in a staircase. 
 * You can either climb 1 or 2 steps at a time. 
 * Write a function that returns the number of unique ways to climb the stairs.
 * 
 * @author Juho Lee
 * @since Jul 31, 2019
 */
public class problem_0014 {

	public int climbStairs(int n) {
		int i = 1, j = 1;
		for(int k = 2; k <= n; k++) {
			int temp = j;
			j += i;
			i = temp;
		}
		return j;
	}
	
}
