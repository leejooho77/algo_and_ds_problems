package com.juho.algo.prac;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
 * Note that k is guaranteed to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
 * For example, there won't be input like 3a or 2[4].
 * 
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * @author Juho Lee
 * @since Sep 26, 2019
 */
public class problem_0082 {

	public String decodeString(String s) {
		// stack for count
		Stack<Integer> numStack = new Stack<>();
		// stack for string
		Stack<String> strStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			// if we found number, get number and push into stack
			if(Character.isDigit(c)) {
				int num = c - '0';
				while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					num = num * 10 + (s.charAt(i + 1) - '0');
					i++;
				}
				numStack.push(num);
			} else if(c == '[')
				// if we found open bracket, push it into stack
				strStack.push(String.valueOf(c));
			else if(c == ']') {
				// get the num of repeat
				int num = numStack.pop();
				// get the substring
				String sub = strStack.pop();
				// using string builder, copy substring
				StringBuilder finalSub = new StringBuilder();
				for(int j = 0; j < num; j++) finalSub.append(sub);
				// pop the open bracket
				strStack.pop();
				// if stack is empty, there is no more bracket in the stack
				// so we can append to our final result
				if(strStack.empty()) {
					sb.append(finalSub);
				} 
				// else we need to append this substring with the string that is in top of the stack
				// and push it again into the stack
				else {
                    if(!strStack.peek().equals("["))
					    strStack.push(strStack.pop() + finalSub.toString());
                    else 
                    	strStack.push(finalSub.toString());
				}
			} else {
				// if we are in bracket
				if(!strStack.empty()) {
					String str = String.valueOf(c);
					if(!strStack.peek().equals("[")) {
						str = strStack.pop() + str;
					}
					strStack.push(String.valueOf(str));
				} else {
					sb.append(c);
				}
			}
            i++;
		}
		return sb.toString();
    }
	
}
