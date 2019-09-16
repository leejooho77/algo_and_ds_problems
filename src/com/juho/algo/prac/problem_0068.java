package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2], Output: [2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4], Output: [9,4]
 * 
 * Note:
 * 	- Each element in the result must be unique.
 * 	- The result can be in any order.
 * 
 * @author Juho Lee
 * @since Sep 16, 2019
 */
public class problem_0068 {

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for(int i : nums1) {
			if(!set.contains(i)) 
				set.add(i);
		}
		List<Integer> list = new ArrayList<>();
		for(int i : nums2) {
			if(set.contains(i)) {
				list.add(i);
				set.remove(i);
			}
		}
        return list.stream().mapToInt(i -> i).toArray();
    }
	
}
