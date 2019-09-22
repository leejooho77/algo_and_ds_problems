package com.juho.algo.prac;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * You are the manager of a number of employees who all sit in a row. 
 * The CEO would like to give bonuses to all of your employees, 
 * but since the company did not perform so well this year the CEO would like to keep the bonuses to a minimum.
 * 
 * The rules of giving bonuses is that:
 * 	- Each employee begins with a bonus factor of 1x.
 * 	- For each employee, if they perform better than the person sitting next to them, 
 * 	  the employee is given +1 higher bonus (and up to +2 if they perform better than both people to their sides).
 * 
 * Given a list of employee's performance, find the bonuses each employee should get.
 * 
 * Example:
 * Input: [1, 2, 3, 2, 3, 5, 1], Output: [1, 2, 3, 1, 2, 3, 1]
 * 
 * @author Juho Lee
 * @since Sep 21, 2019
 */
public class problem_0076 {

	public int[] distribute(int[] perf) {
		int[] result = new int[perf.length];
		for(int i = 0; i < perf.length; i++) {
			result[i] = 1 + measurePerf(perf, i);
		}
		ArrayUtils.print(result);
		return result;
	}
	
	private int measurePerf(int[] perf, int i) {
		int left = (i - 1 >= 0 && perf[i - 1] < perf[i]) ? 1 : 0;
		int right = (i + 1 < perf.length && perf[i + 1] < perf[i]) ? 1 : 0;
		return left + right;
	}
	
}
