package com.juho.algo.prac;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, find the length of the longest substring T that contains at most k distinct characters.
 * 
 * Example 1:
 * Input: S = "eceba" and k = 3, Output: 4
 * Explanation: T = "eceb"
 * 
 * @author Juho Lee
 * @since Sep 01, 2019
 */
public class problem_0046 {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int result = 0, left = 0, right = 0;
		Map<Character, Integer> map = new HashMap<>();
		while(right < s.length()) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			while(map.size() > k) {
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
				if(map.get(s.charAt(left)) == 0)
					map.remove(s.charAt(left));
				left++;
			}
			result = Math.max(result, right - left + 1);
			right++;
		}
		return result;
	}
	
}
