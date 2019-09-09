package com.juho.algo.prac;

/**
 * Given two strings A and B of lowercase letters, 
 * return true if and only if we can swap two letters in A so that the result equals B.
 * 
 * Example 1:
 * Input: A = "ab", B = "ba", Output: true
 * 
 * Example 2:
 * Input: A = "ab", B = "ab", Output: false
 *
 * Example 3:
 * Input: A = "aa", B = "aa", Output: true
 * 
 * Example 4:
 * Input: A = "aaaaaaabc", B = "aaaaaaacb", Output: true
 * 
 * Example 5:
 * Input: A = "", B = "aa", Output: false
 * 
 * @author leejooho77
 * @since Aug 26, 2019
 */
public class problem_0040 {
	
	public boolean buddyStrings(String A, String B) {
		if(A.length() != B.length()) return false;
		int[] charMap = new int[26];
		int swap = 0, repeat = 0;
		for(int i = 0; i < A.length(); i++) {
			char a = A.charAt(i);
			char b = B.charAt(i);
			if(a != b) swap++;
			if(++charMap[a - 'a'] > repeat)
				repeat = charMap[a - 'a'];
		}
		for(int i = 0; i < B.length(); i++) {
			char b = B.charAt(i);
			if(--charMap[b - 'a'] < 0)
				return false;
		}
		return (swap == 0 && repeat > 1) || swap == 2;
	}

}
