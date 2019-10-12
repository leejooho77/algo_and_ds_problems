package com.juho.algo.prac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * Input: [100, 4, 200, 1, 3, 2], Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * @author Juho Lee
 * @since Oct 11, 2019
 */
public class problem_0106 {
	
	public int longestConsecutiveWithMap(int[] nums) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : nums) {
			if(!map.containsKey(i)) {
				int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
				int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;
				max = Math.max(max, left + right + 1);
				map.put(i, left + right + 1);
				// update the each end of the sequence
                if(left > 0) map.put(i - left, left + right + 1);
                if(right > 0) map.put(i + right, left + right + 1);
			}
		}
		return max;
	}

	public int longestConsecutiveWithSet(int[] nums) {
		int max = 0;
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		for(int i : nums) {
			if(set.contains(i)) {
				set.remove(i);
				max = Math.max(max, check(set, i));
			}
		}
        return max;
    }
	
	private int check(Set<Integer> set, int i) {
		int count = 1, up = i + 1, down = i - 1;
		while(!set.isEmpty() && set.contains(up) || set.contains(down)) {
			if(set.contains(up)) {
				count++;
				set.remove(up++);
			}
			if(set.contains(down)) {
				count++;
				set.remove(down--);
			}
		}
		return count;
	}
	
}
