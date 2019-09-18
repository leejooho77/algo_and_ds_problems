package com.juho.algo.prac;

/**
 * Given two integers, an hour and a minute, 
 * write a function to calculate the angle between the two hands on a clock representing that time.
 * 
 * Example 1:
 * Input: 3, 40, Output: 130
 * 
 * @author Juho Lee
 * @since Sep 18, 2019
 */
public class problem_0073 {

	public double anglesOfClock(int hour, int minute) {
		double hrs = convertHrsToAngle(hour, minute);
		double min = convertMinToAngle(minute);
		double result = hrs - min;
		/**
		 * If result is negative, we convert it to positive.
		 * If result is larger than 180, return 360 - result.
		 */
		if(result < 0) result *= -1;
		if(result > 180) result = 360 - result;
		return result;
	}
	
	public double convertMinToAngle(int minute) {
		return (double) minute/5 * 30;
	}
	
	public double convertHrsToAngle(int hour, int minute) {
		return ((double)minute/60 * 30) + hour * 30;
	}
	
}
