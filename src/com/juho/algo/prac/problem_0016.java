package com.juho.algo.prac;

/**
 * Given two strings, determine the edit distance between them. 
 * The edit distance is defined as the minimum number of edits 
 * (insertion, deletion, or substitution) needed to change one string to the other.
 * 
 * For example, "biting" and "sitting" have an edit distance of 2 (substitute b for s, and insert a t).
 *
 * @author Juho Lee
 * @since Aug 02, 2019
 */
public class problem_0016 {
	
	public static int editDistance(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for(int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(s.charAt(i - 1) == t.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
			}
		}
		return dp[s.length()][t.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(editDistance("Sundays", "Saturday"));
	}

}
