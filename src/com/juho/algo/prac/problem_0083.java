package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Two words can be 'chained' if the last character of the first word is the same as the first character of the second word.
 * Given a list of words, determine if there is a way to 'chain' all the words in a circle.
 * 
 * Example:
 * Input: ['eggs', 'karat', 'apple', 'snack', 'tuna'], Output: True
 * Explanation: The words in the order of ['apple', 'eggs', 'snack', 'karat', 'tuna'] creates a circle of chained words.
 * 
 * @author Juho Lee
 * @since Sep 27, 2019
 */
public class problem_0083 {

	public boolean chainedWords(String[] words) {
		// create a map for DFS
		Map<Character, List<String>> map = new HashMap<>();
		// set to store current path
		Set<String> set = new LinkedHashSet<>();
		// construct a graph
		for(String word : words) {
			char c = word.charAt(0);
			map.putIfAbsent(c, new ArrayList<>());
			map.get(c).add(word);
		}
		return chainedWords(map, set, words[0], words);
	}
	
	private boolean chainedWords(Map<Character, List<String>> map, Set<String> set, String start, String[] words) {
		// if we reach at the end of the graph, check if end point is equal to start point
		if(set.size() == words.length && start.equals(words[0]))
			return true;
		else {
			// next key
			char c = start.charAt(start.length() - 1);
			// get the list
			List<String> list = map.get(c);
			for(int i = 0; i < list.size(); i++) {
				String next = list.get(i);
				// if we don't have current string
				if(!set.contains(next)) {
					set.add(next);
					// proceed to next
					if(chainedWords(map, set, next, words))
						return true;
					// if it is not valid, remove the last string
					set.remove(next);
				}
			}
			return false;
		}
	}
	
}
