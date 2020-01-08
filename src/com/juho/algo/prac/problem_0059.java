package com.juho.algo.prac;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...], 
 * find the minimum number of conference rooms required.
 * 
 * Example 1: 
 * Input: [[30,75],[0,50],[60,150]], Output: 2
 * 
 * @author Juho Lee
 * @since Sep 12, 2019
 */
public class problem_0059 {

	/**
	 * Sort the interval based on start time.
	 * Have a heap to store the room.
	 * While iterating the list, if we find overlapping room, push new room
	 * Else pop the existing one and push new room.
	 * 
	 * @param intervals
	 * @return int
	 */
	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			Integer comp = Integer.compare(a[0], b[0]);
			if(comp == 0)
				return Integer.compare(a[1], b[1]);
			else
				return comp;
		});
		PriorityQueue<Integer> rooms = new PriorityQueue<>();
		for(int[] interval : intervals) {
			if(!rooms.isEmpty() && rooms.peek() <= interval[0])
				rooms.poll();
			rooms.add(interval[1]);
		}
		return rooms.size();
	}
	
}
