package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	 * Have an empty list for store the room.
	 * While iterating the list, if we don't find any overlapping room,
	 * switch current interval with new interval.
	 * Else just add new interval at the end.
	 * 
	 * @param intervals
	 * @return int
	 */
	public int meetingRoomsI(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			int compare = Integer.compare(a[0], b[0]);
			if(compare != 0)
				return compare;
			else 
				return Integer.compare(a[1], b[1]);
		});
		List<int[]> rooms = new ArrayList<>();
		for(int[] interval : intervals) {
			checkRooms(rooms, interval);
		}
		return rooms.size();
	}
	
	private void checkRooms(List<int[]> rooms, int[] interval) {
		for(int i = 0; i < rooms.size(); i++) {
			int[] room = rooms.get(i);
			if(room[1] < interval[0]) {
				rooms.remove(room);
				rooms.add(interval);
				return;
			}
		}
		rooms.add(interval);
	}
	
}
