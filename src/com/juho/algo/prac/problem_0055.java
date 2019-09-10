package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * 		["ate","eat","tea"],
 * 		["nat","tan"],
 * 		["bat"]
 * ]
 * 
 * @author Juho Lee
 * @since Sep 10, 2019
 */
public class problem_0055 {
	
	/**
	 * Go to each string and have the sorted string as a key for map.
	 * If we have same key, they are anagram.
	 * Else we haven't found yet, create new list and add itself.
	 * 
	 * @param strs
	 * @return List<List<String>>
	 */
	public List<List<String>> groupAnagramsWithSort(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String s : strs) {
			char[] cs = s.toCharArray();
			Arrays.sort(cs);
			map.putIfAbsent(String.valueOf(cs), new ArrayList<>());
			map.get(String.valueOf(cs)).add(s);
		}
		for(List<String> list : map.values()) {
			result.add(list);
		}
		return result;
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<Integer, List<String>> map = new HashMap<>();
		for(String s : strs) {
			int key = toKey(s);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(s);
		}
		for(List<String> list : map.values()) {
			result.add(list);
		}
		return result;
	}
	
	private int toKey(String str) {
		int[] chars = new int[26];
		for(char c : str.toCharArray()) {
			chars[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i : chars) {
			sb.append(i);
		}
		return sb.toString().hashCode();
	}
	
}
