package com.juho.algo.prac;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * 
 * Example 1:
 * Input: "aba", Output: True
 * 
 * Example 2:
 * Input: "abca", Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * 
 * @author Juho Lee
 * @since Sep 13, 2019
 */
public class problem_0062 {

	/**
	 * With two pointers (start and end), proceed while loop until we see first difference.
	 * When we found first different, now check if one of these are palindrome (start + 1 to end and start to end - 1).
	 * 
	 * @param s
	 * @return boolean
	 */
	public boolean validPalindrome(String s) {
		int start = 0, end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
                return (checkPalindrome(s, start, end - 1) || 
                       checkPalindrome(s, start + 1, end));
			}
			start++;
			end--;
		}
        return true;
    }
    
    public boolean checkPalindrome(String str, int s, int e) {
        while(s < e) {
            if(str.charAt(s++) != str.charAt(e--))
                return false;
        }
        return true;
    }

}
