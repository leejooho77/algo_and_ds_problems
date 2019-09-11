package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * You are given a stream of numbers. Compute the median for each new element.
 * 
 * Eg. Given [2, 1, 4, 7, 2, 0, 5], the algorithm should output [2, 1.5, 2, 3.0, 2, 2, 2]
 * 
 * @author Juho Lee
 * @since Sep 11, 2019
 */
public class problem_0056 {

	/**
	 * With @minHeap and @maxHeap, we can track the median values.
	 * We can have lower values in @maxHeap and higher values in @minHeap.
	 * This way, we can keep two median values at the root of both heaps.
	 * 
	 * @param stream
	 * @return List<Double>
	 */
	public List<Double> runningMedian(Stream<Integer> stream) {
		List<Double> result = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		Iterator<Integer> iter = stream.iterator();
		while(iter.hasNext()) {
			maxHeap.add(iter.next());
			minHeap.add(maxHeap.remove());
			if(maxHeap.size() < minHeap.size())
				maxHeap.add(minHeap.remove());
			result.add((maxHeap.size() == minHeap.size()) ? 
					(maxHeap.peek() + minHeap.peek()) * 0.5 :
					maxHeap.peek());
		}
		return result;
	}
	
}
