package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2], Output: [2,2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4], Output: [4,9]
 * 
 * Note:
 *  - Each element in the result should appear as many times as it shows in both arrays.
 *  - The result can be in any order.
 * 
 * @author Juho Lee
 * @since Sep 16, 2019
 */
public class problem_0069 {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> countMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for(int i : nums1) {
			countMap.put(i, countMap.getOrDefault(i, 0) + 1);
		}
		for(int i : nums2) {
			if(countMap.containsKey(i)) {
				result.add(i);
				countMap.put(i, countMap.get(i) - 1);
				if(countMap.get(i) == 0)
					countMap.remove(i);
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}
	
}
