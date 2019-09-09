package com.juho.algo.prac;

/**
 * A palindrome is a sequence of characters that reads the same backwards and forwards. 
 * Given a string, s, find the longest palindromic substring in s.
 * 
 * Example 1:
 * Input: "banana", Output: "anana"
 * 
 * Example 2:
 * Input: "million", Output: "illi"
 * 
 * @author Juho Lee
 * @since July 19, 2019
 */
public class problem_0003 {
	
	private String max = "";

	/**
	 * 
	 * @param s				string
	 * @return longest palindromic substring in s
	 */
	public String longestPalindrome_1(String s) {
		int n = s.length();
		String max = "";
		boolean[][] dp = new boolean[n][n];
		for(int i = 1; i < n; i++) {
			for(int j = i; j >= 0; j--) {
				if(s.charAt(i) == s.charAt(j)) {
					if(i - j > 3) dp[i][j] = true;
					else if(dp[i - 1][j + 1]) dp[i][j] = true;
				}
				if(dp[i][j] && max.length() < i - j + 1) max = s.substring(j, i + 1); 
			}
		}
		return max;
	}
	
	/**
	 * 
	 * @param s				string
	 * @return longest palindromic substring in s
	 */
	public String longestPalindrome_2(String s) {
		int i = 0, n = s.length();
		while(i < n) {
			expand(s, i, i);
			// for the case of even length of substring
			expand(s, i, i + 1);
			i++;
		}
		return this.max;
	}
	
	/**
	 * 
	 * @param s				string
	 * @param i				start of substring
	 * @param j				start of substring
	 */
	private void expand(String s, int i, int j) {
		while(i >= 0 && j < s.length()) {
			if(s.charAt(i) != s.charAt(j)) return;
			if(this.max.length() < j - i + 1) this.max = s.substring(i, j + 1);
			i++;
			j++;
		}
	}
	
}
