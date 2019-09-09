package com.juho.algo.prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: "abcabcbb", Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * Example 2:
 * Input: "bbbbb", Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: "pwwkew", Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author Juho Lee
 * @since July 18, 2019
 */
public class problem_0002 {
	
	/**
	 * @param s					string
	 * @param map				hashmap to store information of repeating char and its index
	 * @return length of the longest substring without repeating characters
	 */
	public int lengthOfLongestSubstring(String s, Map<Character, Integer> map) {
		int max = 0;
		map = new HashMap<>();
		for(int i = 0, j = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
            map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
	
	/**
	 * @param s					string
	 * @param set				hashset to store previous characters
	 * @return length of the longest substring without repeating characters
	 */
	public int lengthOfLongestSubstring(String s, Set<Character> set) {
		int max = 0, i = 0, j = 0;
		set = new HashSet<>();
		while(i < s.length()) {
			if(!set.contains(s.charAt(i))) {
				set.add(s.charAt(i++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(j++));
			}
		}
		return max;
	}
	
}
