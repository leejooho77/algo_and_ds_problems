package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. 
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * 
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2, Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *               Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4, Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, 
 *               with the number of occurrence being 4, 3, 2 and 1 respectively.
 *               
 * Note:
 *  - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *  - Input words contain only lowercase letters.
 *  
 * Follow up: Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * @author Juho Lee
 * @since Oct 21, 2019
 */
public class problem_0122 {

	// wrapper class for entry
	public class WordEntry {
		int count;
		String word;
		public WordEntry(int count, String word) {
			this.count = count;
			this.word = word;
		}
	}
	
	public List<String> topKFrequent(String[] words, int k) {
		// min heap to store entries in increasing order
		PriorityQueue<WordEntry> heap = new PriorityQueue<>((a, b) -> {
			if(a.count != b.count)
				return Integer.compare(a.count, b.count);
			return b.word.compareTo(a.word);
		});
		// count the occurrence of each word
		Map<String, Integer> map = new HashMap<>();
		for(String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
		// put entries into heap
		while(iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			heap.add(new WordEntry(entry.getValue(), entry.getKey()));
            if(heap.size() > k)
				heap.remove();
		}
		List<String> result = new ArrayList<>();
		// put each entry to front of the list
		while(!heap.isEmpty()) {
			result.add(0, heap.remove().word);
		}
		return result;
	}
	
}
