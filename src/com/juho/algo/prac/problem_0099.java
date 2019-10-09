package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 * 
 * Example 1:
 * Input: S = "aab", Output: "aba"
 * 
 * Example 2:
 * Input: S = "aaab", Output: ""
 * 
 * Note: S will consist of lowercase letters and have length in range [1, 500].
 * 
 * @author Juho Lee
 * @since Oct 6, 2019
 */
public class problem_0099 {

	/**
	 * Using heap (PriorityQueue)
	 * @param s
	 * @return String
	 */
	public String reorganizeStringWithHeap(String s) {
		// to get the count of each chars
		Map<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		// used heap to store each entry in decreasing order
		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> {
			return b.getValue() - a.getValue();
		});
		// put all entries in the heap
		Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			queue.add(iterator.next());
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			// if we only have one entry in the heap, and its value is larger than 1
			// we cannot rearrange the string based on the above rule
			// return empty string
			if(queue.size() < 2 && queue.peek().getValue() > 1)
				return "";
			int interval = 2;
			List<Map.Entry<Character, Integer>> pool = new ArrayList<>();
			while(interval-- > 0 && !queue.isEmpty()) {
				Map.Entry<Character, Integer> entry = queue.remove();
				sb.append(entry.getKey());
				entry.setValue(entry.getValue() - 1);
				pool.add(entry);
			}
			for(Map.Entry<Character, Integer> entry : pool) {
				if(entry.getValue() > 0) queue.add(entry);
			}
		}
		return sb.toString();
	}
	
	public String reorganizeStringOptimized(String s) {
        int[] alphabets = new int[26];
        char[] result = new char[s.length()];
        // count the occurrence of alphabets
        for(char c : s.toCharArray()) {
            alphabets[c - 'a']++;
        }
        // get the max char
        int max = 0, index = 0;
        for(int i = 0; i < alphabets.length; i++) {
            if(alphabets[i] > max) {
                max = alphabets[i];
                index = i;
            }
        }
        // if the max is larger than half of the string, it is impossible to reorganize
        if(max > (s.length() + 1)/2) 
            return "";
        int curr = 0;
        // put max char first
        while(alphabets[index]-- > 0) {
            result[curr] = (char) (index + 'a');
            curr += 2;
        }
        // then put other chars
        for(int i = 0; i < alphabets.length; i++) {
            if(alphabets[i] > 0) {
                while(alphabets[i]-- > 0) {
                	// if we reach at the end, set curr to 1 and proceed
                    if(curr >= result.length)
                        curr = 1;
                    result[curr] = (char) (i + 'a');
                    curr += 2;
                }
            }
        }
        return String.valueOf(result);
    }
	
}
