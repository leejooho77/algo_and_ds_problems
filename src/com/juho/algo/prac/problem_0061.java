package com.juho.algo.prac;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence 
 * while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * Input: "Let's take LeetCode contest", Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * 
 * @author Juho Lee
 * @since Sep 13, 2019
 */
public class problem_0061 {
	
	/**
	 * As we iterate each char in the String, 
	 * We can mark left as a starting char,
	 * And we can mark right as a ending char.
	 * Whenever, the right meet empty space we can reverse the word.
	 * 
	 * @param s
	 * @return String
	 */
	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		for(int left = 0, right = 0; right < chars.length; right++) {
			if(right == chars.length - 1 && left >= 0 && chars[right] != ' ')
				reverse(chars, left, right);
			else if(chars[right] == ' ' && left >= 0) {
				reverse(chars, left, right - 1);
				left = -1;
			} else {
				if(left < 0)
					left = right;
			}
		}
        return String.valueOf(chars);
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
