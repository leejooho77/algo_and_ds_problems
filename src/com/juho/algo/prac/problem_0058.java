package com.juho.algo.prac;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , 
 * determine if a person could attend all meetings.
 * 
 * Example 1:
 * Input: [ [0, 30], [5, 10], [15, 20] ], Output: false
 * 
 * @author Juho Lee
 * @since Sep 12, 2019
 */
public class problem_0058 {

	/**
	 * First, sort the intervals based on the start time.
	 * Loop through the intervals and if we found two overlapping intervals, return false.
	 * Else return true.
	 * 
	 * @param intervals
	 * @return boolean
	 */
	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			int compare = Integer.compare(a[0], b[0]);
			if(compare != 0) 
				return compare;
			else 
				return Integer.compare(a[1], b[1]);
		});
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i - 1][1] >= intervals[i][0])
				return false;
		}
		return true;
	}
	
}
