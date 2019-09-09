package com.juho.algo.prac;

/**
 * Given a list of words, and an arbitrary alphabetical order, 
 * verify that the words are in order of the alphabetical order.
 * 
 * Example:
 * Input: words = ["abcd", "efgh"], order="zyxwvutsrqponmlkjihgfedcba", Output: False
 * Explanation: 'e' comes before 'a' so 'efgh' should come before 'abcd'
 * 
 * Example 2:
 * Input: words = ["zyx", "zyxw", "zyxwy"], order="zyxwvutsrqponmlkjihgfedcba", Output: True
 * Explanation: The words are in increasing alphabetical order
 * 
 * @author Juho Lee
 * @since Sep 05, 2019
 */
public class problem_0050 {

	public boolean isSorted(String[] words, String order) {
		for(int i = 1; i < words.length; i++) {
			int j = 0;
			if(words[i - 1].equals(words[i])) continue;
			while(j < words[i - 1].length() && j < words[i].length() && 
				words[i - 1].charAt(j) == words[i].charAt(j)) 
				j++;
			if(j < words[i - 1].length() && j < words[i].length()) {
				char c1 = words[i - 1].charAt(j), c2 = words[i].charAt(j);
				if(order.indexOf(c1) > order.indexOf(c2)) 
					return false;
			} else if(j < words[i].length()) 
				continue;
			else 
				return false;
		}
		return true;
	}
	
}
