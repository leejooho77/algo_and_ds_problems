package com.juho.algo.prac;

/**
 * Given an input string, reverse the string word by word.
 * 
 * Example 1:
 * Input: "the sky is blue", Output: "blue is sky the"
 * 
 * Example 2:
 * Input: "  hello world!  ", Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces
 * 
 * Example 3:
 * Input: "a good   example", Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * 
 * Note:
 * 	- A word is defined as a sequence of non-space characters.
 * 	- Input string may contain leading or trailing spaces. 
 * 	  However, your reversed string should not contain leading or trailing spaces.
 * 	- You need to reduce multiple spaces between two words to a single space in the reversed string.
 * 
 * @author Juho Lee
 * @since Sep 13, 2019
 */
public class problem_0060 {

	/**
	 * First, reverse the entire string.
	 * Then, reverse each words.
	 * To eliminate duplicate space, we can split the reversed string with empty space,
	 * And add each word to result with an additional space.
	 * 
	 * @param s
	 * @return String
	 */
	public String reverseWords(String s) {
		s = s.trim();
		char[] chars = s.toCharArray();
		reverse(chars, 0, chars.length - 1);
		for(int left = 0, right = 0; right < chars.length; right++) {
			if(right == chars.length - 1 && left >= 0 && chars[right] != ' ') {
				reverse(chars, left, right);
			} else if(chars[right] == ' ' && left >= 0) {
				reverse(chars, left, right - 1);
				left = -1;
			} else {
				if(left < 0)
					left = right;
			}
		}
		StringBuilder result = new StringBuilder();
		for(String str : String.valueOf(chars).split(" ")) {
			if(str.length() > 0)
				result.append(str).append(" ");
		}
		return result.toString().trim();
    }
	
	private void reverse(char[] chars, int start, int end) {
		while(start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

}
