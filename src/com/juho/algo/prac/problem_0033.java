package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.juho.algo.prac.ds.Interval;

/**
 * You are given an array of intervals - that is, an array of tuples (start, end). 
 * The array may not be sorted, and could contain overlapping intervals. Return another array where the overlapping intervals are merged.
 * 
 * For example:
 * [(1, 3), (5, 8), (4, 10), (20, 25)]
 * This input should return [(1, 3), (4, 10), (20, 25)] since (5, 8) and (4, 10) can be merged into (4, 10).

 * 
 * @author leejooho77
 * @since Aug 19, 2019
 */
public class problem_0033 {

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, (a, b) -> {
			int comp = Integer.compare(a.start, b.start);
			if(comp != 0) return comp;
			return a.end - b.end;
		});
		List<Interval> result = new ArrayList<>();
		Interval interval = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++) {
			if(i == intervals.size()) result.add(interval);
			if(interval.end >= intervals.get(i).start) {
				if(interval.end < intervals.get(i).end)
					interval.end = intervals.get(i).end;
			} else {
				result.add(interval);
				interval = intervals.get(i);
			}
		}
		return result;
	}
	
}
