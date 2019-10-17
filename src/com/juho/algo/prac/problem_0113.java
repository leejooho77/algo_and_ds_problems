package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, 
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".
 * 
 * Given a list of strings which contains only lowercase alphabets, 
 * group all strings that belong to the same shifting sequence.
 * 
 * Example:
 * Input: ["a","abc","acef","az","ba","bcd","xyz","z"], 
 * Output: 
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 * 
 * @author Juho Lee
 * @since Oct 15, 2019
 */
public class problem_0113 {

	public List<List<String>> groupStrings(List<String> strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String s : strs) {
			StringBuilder sb = new StringBuilder();
			int diff = s.charAt(0) - 'a';
			for(int i = 0; i < s.length(); i++) {
				int curr = (s.charAt(i) - 'a') - diff;
				if(Math.abs(curr) == 25)
					curr = -curr/25;
				sb.append(curr);
			}
			map.putIfAbsent(sb.toString(), new ArrayList<>());
			map.get(sb.toString()).add(s);
		}
		result.addAll(map.values());
		return result;
	}
	
}
